package org.bian.pubsub;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PubSubConsumer.
 */
public class PubSubConsumer {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LoggerFactory.getLogger(PubSubConsumer.class);
	
	/** The offset reset earlier. */
	private String brokers, groupIdConfig, offsetResetEarlier;
	
	/** The no msg found count. */
	private int maxPollRecords, noMsgFoundCount;
	
	/**
	 * Instantiates a new pub sub consumer.
	 *
	 * @param brokers the brokers
	 * @param groupIdConfig the group id config
	 * @param maxPollRecords the max poll records
	 * @param offsetResetEarlier the offset reset earlier
	 * @param noMsgFoundCount the no msg found count
	 */
	public PubSubConsumer(String brokers, String groupIdConfig, int maxPollRecords, String offsetResetEarlier, int noMsgFoundCount) {
		this.brokers = brokers;
		this.groupIdConfig = groupIdConfig;
		this.maxPollRecords = maxPollRecords;
		this.offsetResetEarlier = offsetResetEarlier;
		this.noMsgFoundCount = noMsgFoundCount;
	}
	
	/**
	 * Register async.
	 *
	 * @param topic the topic
	 * @param task the task
	 */
	public void registerAsync(String topic, PubSubTask task) {
		new Thread() {
			@Override
			public void run() {
				register(topic,  task);
			}
		}.start();
	}

	/**
	 * Register.
	 *
	 * @param topic the topic
	 * @param task the task
	 */
	public void register(String topic, PubSubTask task) {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, this.groupIdConfig);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, this.maxPollRecords);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, this.offsetResetEarlier);

		final Consumer<Long, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList(topic));

		int noMessageToFetch = 0;

		while (true) {
			final ConsumerRecords<Long, String> consumerRecords = consumer.poll(1000);
			if (consumerRecords.count() == 0) {
				noMessageToFetch++;
				if (noMessageToFetch > this.noMsgFoundCount)
					break;
				else
					continue;
			}

			consumerRecords.forEach(record -> {
				LOGGER.debug("Pub-sub Record Key " + record.key());
				LOGGER.debug("Pub-sub Record value " + record.value());
				LOGGER.debug("Pub-sub Record partition " + record.partition());
				LOGGER.debug("Pub-sub Record offset " + record.offset());
				task.go(record.value());
			});
			consumer.commitAsync();
		}
		consumer.close();
	}
}
