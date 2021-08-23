package by.tc.task01.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.entity.Refrigerator;

public class RefrigeratorCreator implements ApplianceCreator {

	public Refrigerator create(String string) {

		Refrigerator.Builder refrigeratorBuilder = BuildersFactory.getBuildersFactory().getRefrigeratorBuilder();

		try {
			String s = string;

			Pattern pattern = Pattern.compile("POWER_CONSUMPTION=[0-9]*[.]?[0-9]*");
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.powerConsumption(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("WEIGHT=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.weight(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("FREEZER_CAPACITY=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.freezerCapacity(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("WIDTH=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.width(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("OVERALL_CAPACITY=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.overallCapacity(Double.parseDouble(split[1]));
			}

			pattern = Pattern.compile("HEIGHT=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				String characteristic = matcher.group();
				String[] split = characteristic.split("=");
				refrigeratorBuilder.height(Integer.parseInt(split[1]));
			}
			return refrigeratorBuilder.build();
		} finally {
			refrigeratorBuilder.clear();
		}

	}
}
