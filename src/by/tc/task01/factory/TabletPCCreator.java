package by.tc.task01.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;

public class TabletPCCreator implements ApplianceCreator {

	public Appliance create(String string) {

		TabletPC.Builder tabletPCBuilder = BuildersFactory.getBuildersFactory().getTabletPCBuilder();

		try {
			String s = string;
			String characteristic;
			String[] split;

			Pattern pattern = Pattern.compile("BATTERY_CAPACITY=[0-9]*[.]?[0-9]*");
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				tabletPCBuilder.batteryCapacity(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("DISPLAY_INCHES=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				tabletPCBuilder.displayInchs(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("MEMORY_ROM=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				tabletPCBuilder.memoryRom(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("FLASH_MEMORY_CAPACITY=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				tabletPCBuilder.flashMemoryCapacity(Integer.parseInt(split[1]));
			}
			pattern = Pattern.compile("COLOR=\\w*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				tabletPCBuilder.color(split[1]);
			}
			return tabletPCBuilder.build();
		} finally {
			tabletPCBuilder.clear();
		}
	}
}
