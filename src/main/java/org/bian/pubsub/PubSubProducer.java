package org.bian.pubsub;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class PubSubProducer.
 */
public class PubSubProducer {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LoggerFactory.getLogger(PubSubProducer.class);
	
	/** The client id. */
	private String brokers, clientId;
	
	/**
	 * Instantiates a new pub sub producer.
	 *
	 * @param brokers the brokers
	 * @param clientId the client id
	 */
	public PubSubProducer(String brokers, String clientId) {
		this.brokers = brokers;
		this.clientId = clientId;
	}

	/**
	 * Produce.
	 *
	 * @param topic the topic
	 * @param content the content
	 */
	public void produce(String topic, String content) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokers);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, this.clientId);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		Producer<Long, String> producer = new KafkaProducer<>(props);

		final ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(topic, content);
		try {
			RecordMetadata metadata = producer.send(record).get();
			LOGGER.debug("Pub-sub Message '" + content + "' sent to partition " + metadata.partition() + " with offset "
					+ metadata.offset());
		} catch (ExecutionException | InterruptedException e) {
			LOGGER.warn("Error in sending record. ", e);
		} finally {
			producer.close();
		}
	}
}
