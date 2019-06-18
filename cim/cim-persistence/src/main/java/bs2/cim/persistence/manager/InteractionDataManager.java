package bs2.cim.persistence.manager;

import org.springframework.stereotype.Component;

/**
 * The implementation of the InteractionData interface.
 * 
 * @author Anton Nazarov
 * @since 05/06/2019
 */
@Component
public class InteractionDataManager implements InteractionData {

	@Override
	public void storeScratchPadEntry(String subscriberSeq, String subId, String subIdType, String subscriberType,
			String spName, String interactionDate, String callId, String userName, String accountId, String source,
			String topicCode, String comment) {
		// TODO Auto-generated method stub

	}
}
