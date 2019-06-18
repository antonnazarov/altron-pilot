package bs2.cim.persistence.manager;

/**
 * The Customer Interaction functions have been presented in this interface.
 * 
 * @author Anton Nazarov
 * @since 03/06/2019
 */
public interface InteractionData {

	void storeScratchPadEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
			String spName, String interactionDate, String callId, String userName, String accountId, String source,
			String topicCode, String comment);
}
