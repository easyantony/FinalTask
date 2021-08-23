package by.tc.task01.entity;

public class Laptop extends Appliance{
	
	private final double batteryCapacity;
	private final String oS;
	private final int memoryRom;
	private final int systemMemory;
	private final double cPU;
	private final int displayInches;

	private Laptop(Builder builder) {
		this.batteryCapacity = builder.batteryCapacity;
		this.oS = builder.oS;
		this.memoryRom = builder.memoryRom;
		this.systemMemory = builder.systemMemory;
		this.cPU = builder.cPU;
		this.displayInches = builder.displayInchs;

	}

	public static class Builder {
		private double batteryCapacity;
		private String oS;
		private int memoryRom;
		private int systemMemory;
		private double cPU;
		private int displayInchs;

		public Builder batteryCapacity(double batteryCapacity) {
			this.batteryCapacity = batteryCapacity;
			return this;
		}

		public Builder oS(String oS) {
			this.oS = oS;
			return this;
		}

		public Builder memoryRom(int memoryRom) {
			this.memoryRom = memoryRom;
			return this;
		}

		public Builder systemMemory(int systemMemory) {
			this.systemMemory = systemMemory;
			return this;
		}

		public Builder cPU(double cPU) {
			this.cPU = cPU;
			return this;
		}

		public Builder displayInchs(int displayInchs) {
			this.displayInchs = displayInchs;
			return this;
		}

		public Laptop build() {
			return new Laptop(this);
		}
		
		public Builder clear() {
			this.batteryCapacity = 0.0;
			this.oS = null;
			this.memoryRom = 0;
			this.systemMemory = 0;
			this.cPU = 0;
			this.displayInchs = 0;
			
			return this;
			
		}

	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public String getoS() {
		return oS;
	}

	public int getMemoryRom() {
		return memoryRom;
	}

	public int getSystemMemory() {
		return systemMemory;
	}

	public double getcPU() {
		return cPU;
	}

	public int getDisplayInchs() {
		return displayInches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(batteryCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cPU);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + displayInches;
		result = prime * result + memoryRom;
		result = prime * result + ((oS == null) ? 0 : oS.hashCode());
		result = prime * result + systemMemory;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (Double.doubleToLongBits(batteryCapacity) != Double.doubleToLongBits(other.batteryCapacity))
			return false;
		if (Double.doubleToLongBits(cPU) != Double.doubleToLongBits(other.cPU))
			return false;
		if (displayInches != other.displayInches)
			return false;
		if (memoryRom != other.memoryRom)
			return false;
		if (oS == null) {
			if (other.oS != null)
				return false;
		} else if (!oS.equals(other.oS))
			return false;
		if (systemMemory != other.systemMemory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Laptop [batteryCapacity=" + batteryCapacity + ", oS=" + oS + ", memoryRom=" + memoryRom
				+ ", systemMemory=" + systemMemory + ", cPU=" + cPU + ", displayInches=" + displayInches + "]";
	}

	@Override
	public String ApplianceToString() {
		return "Laptop : BATTERY_CAPACITY=" + batteryCapacity + ", OS=" + oS + ", MEMORY_ROM=" + memoryRom
				+ ", SYSTEM_MEMORY=" + systemMemory + ", CPU=" + cPU + ", DISPLAY_INCHES=" + displayInches;
	}

}
