/*
 * generated by Xtext 2.19.0
 */
package yu0323.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import yu0323.parser.antlr.internal.InternalRucmParser;
import yu0323.services.RucmGrammarAccess;

public class RucmParser extends AbstractAntlrParser {

	@Inject
	private RucmGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalRucmParser createParser(XtextTokenStream stream) {
		return new InternalRucmParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "UCModel";
	}

	public RucmGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(RucmGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}