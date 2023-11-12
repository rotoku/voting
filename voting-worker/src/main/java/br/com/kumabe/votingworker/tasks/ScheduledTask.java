package br.com.kumabe.votingworker.tasks;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.kumabe.votingworker.models.Voting;
import br.com.kumabe.votingworker.services.VotingWorkerService;

@Component
public class ScheduledTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Autowired
	private VotingWorkerService votingWorkerService;
	
	@Value("${languages}")
	private String[] languages;
	
	@Scheduled(cron = "0 */5 * * * *")
	public void run() {
		LOGGER.info("Run at {}.", LocalDateTime.now());
		for(String language : languages) {			
			Long amount = (Long)votingWorkerService.retrieveFromRedis(language); 
			if(amount != null) {
				LOGGER.info("Language: {} - Amount: {}", language, amount);
				Voting voting = new Voting(language, amount);
				votingWorkerService.createFromPostgres(voting);
				votingWorkerService.deleteFromRedis(language);
			}
		}
	}
}
