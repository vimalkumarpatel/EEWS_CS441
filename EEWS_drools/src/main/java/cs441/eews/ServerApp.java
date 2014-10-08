package cs441.eews;

import java.sql.Date;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import cs441.eews.entity.interfaces.IRegion;
import cs441.eews.interfaces.IMySQLUtils;



public class ServerApp {

	@SuppressWarnings("deprecation")
	public static final void main(String[] args) throws Exception {
		
		IMySQLUtils utils = MySQLUtils.getSingleton();
		Fetcher updateThread = new Fetcher(null);
		updateThread.start();
		
		try {
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();
			StatefulKnowledgeSession ksession = kbase
					.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
					.newFileLogger(ksession, "test");

			IRegion regions[] = utils.getAllRegions();
			for(IRegion r: regions){
				ksession.insert(r);
			}
			ksession.setGlobal("startdate", new Date(2012-1900,0,2));
			ksession.setGlobal("enddate", new Date(2012-1900,0,20));
			ksession.fireAllRules();
			utils.saveRegionEP();
			logger.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
		updateThread.join();
		utils.close();
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource("Sample.drl"),
				ResourceType.DRL);
		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}
		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}
}
