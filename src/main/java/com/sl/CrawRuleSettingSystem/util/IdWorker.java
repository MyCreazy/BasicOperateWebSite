package com.sl.CrawRuleSettingSystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 产生随机数
 * @author Administrator
 *
 */
public class IdWorker {
	private long workerId;
	private final static long twepoch = 1288834974657L;
	private long sequence = 0L;
	private final static long workerIdBits = 30L;
	public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
	private final static long sequenceBits = 10L;
	private final static long workerIdShift = sequenceBits;
	private final static long timestampLeftShift = sequenceBits + workerIdBits;
	public final static long sequenceMask = -1L ^ -1L << sequenceBits;
	private long lastTimestamp = -1L;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public IdWorker(final long workerId) {
		super();
		if (workerId > this.maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
		}
		this.workerId = workerId;
	}

	private int getRandom(int count) {
		return (int) Math.round(Math.random() * (count));
	}

	private static String tempstring = "abcdefghijklmnopqrstuvwxyz";

	private String getRandomString(int length) {
		StringBuffer sb = new StringBuffer();
		int len = tempstring.length();
		for (int i = 0; i < length; i++) {
			sb.append(tempstring.charAt(getRandom(len - 1)));
		}
		return sb.toString();
	}

	private synchronized String nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & this.sequenceMask;
			if (this.sequence == 0) {
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			try {
				throw new Exception(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
						this.lastTimestamp - timestamp));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - twepoch << timestampLeftShift)) | (this.workerId << this.workerIdShift)
				| (this.sequence);
		String tempstr = String.valueOf(nextId);
		long tempcount = tempstr.length();
		long gapnum = this.workerId - tempcount;
		String randomstr = this.getRandomString((int) gapnum);
		String result = nextId + randomstr;
		return result;
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取KeyID
	 * @param isuseTime 是否在前面加上时间
	 * @return 返回KeyID
	 */
	public String getKeyID(boolean isuseTime)
	{
		String keyid="";
		if(isuseTime)
		{
			String temp=df.format(new Date());
			temp=temp.trim().replace("-", "").replace(":", "").replaceAll(" +", "");
			temp+=this.nextId().substring(0, 11);
			keyid=temp;
		}
		else
		{
			keyid=this.nextId();
		}
		
		return keyid;
	}
}
