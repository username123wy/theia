package yu0323.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import yu0323.services.RucmGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRucmParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ucmodel'", "'actor'", "'usecase'", "'=>'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_INT=5;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

    // delegates
    // delegators


        public InternalRucmParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRucmParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRucmParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRucm.g"; }



     	private RucmGrammarAccess grammarAccess;

        public InternalRucmParser(TokenStream input, RucmGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "UCModel";
       	}

       	@Override
       	protected RucmGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleUCModel"
    // InternalRucm.g:64:1: entryRuleUCModel returns [EObject current=null] : iv_ruleUCModel= ruleUCModel EOF ;
    public final EObject entryRuleUCModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCModel = null;


        try {
            // InternalRucm.g:64:48: (iv_ruleUCModel= ruleUCModel EOF )
            // InternalRucm.g:65:2: iv_ruleUCModel= ruleUCModel EOF
            {
             newCompositeNode(grammarAccess.getUCModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCModel=ruleUCModel();

            state._fsp--;

             current =iv_ruleUCModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCModel"


    // $ANTLR start "ruleUCModel"
    // InternalRucm.g:71:1: ruleUCModel returns [EObject current=null] : (otherlv_0= 'ucmodel' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )* ) ;
    public final EObject ruleUCModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_actor_2_0 = null;

        EObject lv_usecase_3_0 = null;



        	enterRule();

        try {
            // InternalRucm.g:77:2: ( (otherlv_0= 'ucmodel' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )* ) )
            // InternalRucm.g:78:2: (otherlv_0= 'ucmodel' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )* )
            {
            // InternalRucm.g:78:2: (otherlv_0= 'ucmodel' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )* )
            // InternalRucm.g:79:3: otherlv_0= 'ucmodel' ( (lv_name_1_0= RULE_ID ) ) ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )*
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUCModelAccess().getUcmodelKeyword_0());
            		
            // InternalRucm.g:83:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRucm.g:84:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRucm.g:84:4: (lv_name_1_0= RULE_ID )
            // InternalRucm.g:85:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUCModelAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUCModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRucm.g:101:3: ( ( (lv_actor_2_0= ruleActor ) ) | ( (lv_usecase_3_0= ruleUseCase ) ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }
                else if ( (LA1_0==13) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalRucm.g:102:4: ( (lv_actor_2_0= ruleActor ) )
            	    {
            	    // InternalRucm.g:102:4: ( (lv_actor_2_0= ruleActor ) )
            	    // InternalRucm.g:103:5: (lv_actor_2_0= ruleActor )
            	    {
            	    // InternalRucm.g:103:5: (lv_actor_2_0= ruleActor )
            	    // InternalRucm.g:104:6: lv_actor_2_0= ruleActor
            	    {

            	    						newCompositeNode(grammarAccess.getUCModelAccess().getActorActorParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_actor_2_0=ruleActor();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUCModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"actor",
            	    							lv_actor_2_0,
            	    							"yu0323.Rucm.Actor");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalRucm.g:122:4: ( (lv_usecase_3_0= ruleUseCase ) )
            	    {
            	    // InternalRucm.g:122:4: ( (lv_usecase_3_0= ruleUseCase ) )
            	    // InternalRucm.g:123:5: (lv_usecase_3_0= ruleUseCase )
            	    {
            	    // InternalRucm.g:123:5: (lv_usecase_3_0= ruleUseCase )
            	    // InternalRucm.g:124:6: lv_usecase_3_0= ruleUseCase
            	    {

            	    						newCompositeNode(grammarAccess.getUCModelAccess().getUsecaseUseCaseParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_usecase_3_0=ruleUseCase();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUCModelRule());
            	    						}
            	    						add(
            	    							current,
            	    							"usecase",
            	    							lv_usecase_3_0,
            	    							"yu0323.Rucm.UseCase");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCModel"


    // $ANTLR start "entryRuleActor"
    // InternalRucm.g:146:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalRucm.g:146:46: (iv_ruleActor= ruleActor EOF )
            // InternalRucm.g:147:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalRucm.g:153:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_relationship_2_0= ruleRelationship ) )* ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_relationship_2_0 = null;



        	enterRule();

        try {
            // InternalRucm.g:159:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_relationship_2_0= ruleRelationship ) )* ) )
            // InternalRucm.g:160:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_relationship_2_0= ruleRelationship ) )* )
            {
            // InternalRucm.g:160:2: (otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_relationship_2_0= ruleRelationship ) )* )
            // InternalRucm.g:161:3: otherlv_0= 'actor' ( (lv_name_1_0= RULE_ID ) ) ( (lv_relationship_2_0= ruleRelationship ) )*
            {
            otherlv_0=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalRucm.g:165:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRucm.g:166:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRucm.g:166:4: (lv_name_1_0= RULE_ID )
            // InternalRucm.g:167:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActorAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalRucm.g:183:3: ( (lv_relationship_2_0= ruleRelationship ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalRucm.g:184:4: (lv_relationship_2_0= ruleRelationship )
            	    {
            	    // InternalRucm.g:184:4: (lv_relationship_2_0= ruleRelationship )
            	    // InternalRucm.g:185:5: lv_relationship_2_0= ruleRelationship
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getRelationshipRelationshipParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_5);
            	    lv_relationship_2_0=ruleRelationship();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"relationship",
            	    						lv_relationship_2_0,
            	    						"yu0323.Rucm.Relationship");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleUseCase"
    // InternalRucm.g:206:1: entryRuleUseCase returns [EObject current=null] : iv_ruleUseCase= ruleUseCase EOF ;
    public final EObject entryRuleUseCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUseCase = null;


        try {
            // InternalRucm.g:206:48: (iv_ruleUseCase= ruleUseCase EOF )
            // InternalRucm.g:207:2: iv_ruleUseCase= ruleUseCase EOF
            {
             newCompositeNode(grammarAccess.getUseCaseRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUseCase=ruleUseCase();

            state._fsp--;

             current =iv_ruleUseCase; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUseCase"


    // $ANTLR start "ruleUseCase"
    // InternalRucm.g:213:1: ruleUseCase returns [EObject current=null] : (otherlv_0= 'usecase' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUseCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalRucm.g:219:2: ( (otherlv_0= 'usecase' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalRucm.g:220:2: (otherlv_0= 'usecase' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalRucm.g:220:2: (otherlv_0= 'usecase' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalRucm.g:221:3: otherlv_0= 'usecase' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUseCaseAccess().getUsecaseKeyword_0());
            		
            // InternalRucm.g:225:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalRucm.g:226:4: (lv_name_1_0= RULE_ID )
            {
            // InternalRucm.g:226:4: (lv_name_1_0= RULE_ID )
            // InternalRucm.g:227:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getUseCaseAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getUseCaseRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUseCase"


    // $ANTLR start "entryRuleRelationship"
    // InternalRucm.g:247:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // InternalRucm.g:247:53: (iv_ruleRelationship= ruleRelationship EOF )
            // InternalRucm.g:248:2: iv_ruleRelationship= ruleRelationship EOF
            {
             newCompositeNode(grammarAccess.getRelationshipRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // InternalRucm.g:254:1: ruleRelationship returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalRucm.g:260:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalRucm.g:261:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalRucm.g:261:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) ) )
            // InternalRucm.g:262:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (otherlv_2= RULE_ID ) )
            {
            // InternalRucm.g:262:3: ( (otherlv_0= RULE_ID ) )
            // InternalRucm.g:263:4: (otherlv_0= RULE_ID )
            {
            // InternalRucm.g:263:4: (otherlv_0= RULE_ID )
            // InternalRucm.g:264:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationshipRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(otherlv_0, grammarAccess.getRelationshipAccess().getActorActorCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getRelationshipAccess().getEqualsSignGreaterThanSignKeyword_1());
            		
            // InternalRucm.g:279:3: ( (otherlv_2= RULE_ID ) )
            // InternalRucm.g:280:4: (otherlv_2= RULE_ID )
            {
            // InternalRucm.g:280:4: (otherlv_2= RULE_ID )
            // InternalRucm.g:281:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRelationshipRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getRelationshipAccess().getUsecaseUseCaseCrossReference_2_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});

}