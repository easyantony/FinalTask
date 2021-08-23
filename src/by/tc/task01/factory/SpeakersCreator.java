package by.tc.task01.factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

public class SpeakersCreator implements ApplianceCreator {

	public Appliance create(String string) {

		Speakers.Builder speakersBuilder = BuildersFactory.getBuildersFactory().getSpeakersBuilder();

		try {
			String s = string;
			String characteristic;
			String[] split;

			Pattern pattern = Pattern.compile("POWER_CONSUMPTION=[0-9]*[.]?[0-9]*");
			Matcher matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				speakersBuilder.powerConsumption(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("NUMBER_OF_SPEAKERS=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				speakersBuilder.numberOfSpeakers(Integer.parseInt(split[1]));
			}

			pattern = Pattern.compile("FREQUENCY_RANGE=[0-9]*[.]?[0-9]?[-]?[0-9]*[.]?[0-9]?");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				speakersBuilder.frequencyRange(split[1]);
			}

			pattern = Pattern.compile("CORD_LENGTH=[0-9]*[.]?[0-9]*");
			matcher.reset();
			matcher = pattern.matcher(s);
			if (matcher.find()) {
				characteristic = matcher.group();
				split = characteristic.split("=");
				speakersBuilder.cordLength(Integer.parseInt(split[1]));
			}

			return speakersBuilder.build();
		} finally {
			speakersBuilder.clear();
		}
	}
}
