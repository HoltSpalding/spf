package edu.cornell.cs.nlp.spf.diarclex;

import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import edu.cornell.cs.nlp.spf.base.hashvector.HashVectorFactory;
import edu.cornell.cs.nlp.spf.base.hashvector.HashVectorFactory.Type;
import edu.cornell.cs.nlp.spf.base.hashvector.KeyArgs;
import edu.cornell.cs.nlp.spf.ccg.categories.syntax.Syntax;
import edu.cornell.cs.nlp.spf.ccg.lexicon.ILexicon;
import edu.cornell.cs.nlp.spf.ccg.lexicon.LexicalEntry;
import edu.cornell.cs.nlp.spf.ccg.lexicon.LexicalEntry.Origin;
import edu.cornell.cs.nlp.spf.ccg.lexicon.Lexicon;
import edu.cornell.cs.nlp.spf.ccg.lexicon.factored.lambda.FactoredLexicalEntry;
import edu.cornell.cs.nlp.spf.ccg.lexicon.factored.lambda.FactoredLexicon;
import edu.cornell.cs.nlp.spf.ccg.lexicon.factored.lambda.FactoringServices;
import edu.cornell.cs.nlp.spf.data.collection.CompositeDataCollection;
import edu.cornell.cs.nlp.spf.data.collection.IDataCollection;
import edu.cornell.cs.nlp.spf.data.sentence.Sentence;
import edu.cornell.cs.nlp.spf.data.sentence.SentenceLengthFilter;
import edu.cornell.cs.nlp.spf.data.singlesentence.SingleSentence;
import edu.cornell.cs.nlp.spf.data.singlesentence.SingleSentenceCollection;
import edu.cornell.cs.nlp.spf.data.utils.LabeledValidator;
import edu.cornell.cs.nlp.spf.genlex.ccg.ILexiconGenerator;
import edu.cornell.cs.nlp.spf.genlex.ccg.template.TemplateSupervisedGenlex;
import edu.cornell.cs.nlp.spf.learn.ILearner;
import edu.cornell.cs.nlp.spf.learn.validation.stocgrad.ValidationStocGrad;
import edu.cornell.cs.nlp.spf.learn.validation.stocgrad.ValidationStocGrad.Builder;
import edu.cornell.cs.nlp.spf.mr.lambda.FlexibleTypeComparator;
import edu.cornell.cs.nlp.spf.mr.lambda.LogicLanguageServices;
import edu.cornell.cs.nlp.spf.mr.lambda.LogicalConstant;
import edu.cornell.cs.nlp.spf.mr.lambda.LogicalExpression;
import edu.cornell.cs.nlp.spf.mr.lambda.ccg.LogicalExpressionCategoryServices;
import edu.cornell.cs.nlp.spf.mr.lambda.ccg.SimpleFullParseFilter;
import edu.cornell.cs.nlp.spf.mr.language.type.TypeRepository;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.CKYBinaryParsingRule;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.CKYUnaryParsingRule;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.logger.ChartLogger;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.single.CKYParser;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.sloppy.BackwardSkippingRule;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.sloppy.ForwardSkippingRule;
import edu.cornell.cs.nlp.spf.parser.ccg.cky.sloppy.SimpleWordSkippingLexicalGenerator;
import edu.cornell.cs.nlp.spf.parser.ccg.factoredlex.features.FactoredLexicalFeatureSet;
import edu.cornell.cs.nlp.spf.parser.ccg.features.basic.DynamicWordSkippingFeatures;
import edu.cornell.cs.nlp.spf.parser.ccg.features.basic.LexicalFeaturesInit;
import edu.cornell.cs.nlp.spf.parser.ccg.features.basic.scorer.ExpLengthLexicalEntryScorer;
import edu.cornell.cs.nlp.spf.parser.ccg.features.lambda.LogicalExpressionCoordinationFeatureSet;
import edu.cornell.cs.nlp.spf.parser.ccg.lambda.pruning.SupervisedFilterFactory;
import edu.cornell.cs.nlp.spf.parser.ccg.model.LexiconModelInit;
import edu.cornell.cs.nlp.spf.parser.ccg.model.Model;
import edu.cornell.cs.nlp.spf.parser.ccg.model.ModelLogger;
import edu.cornell.cs.nlp.spf.parser.ccg.normalform.NormalFormValidator;
import edu.cornell.cs.nlp.spf.parser.ccg.normalform.hb.HBComposedConstraint;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.lambda.PluralExistentialTypeShifting;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.lambda.ThatlessRelative;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.lambda.typeraising.ForwardTypeRaisedComposition;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.lambda.typeshifting.PrepositionTypeShifting;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.primitivebinary.application.BackwardApplication;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.primitivebinary.application.ForwardApplication;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.primitivebinary.composition.BackwardComposition;
import edu.cornell.cs.nlp.spf.parser.ccg.rules.primitivebinary.composition.ForwardComposition;
import edu.cornell.cs.nlp.spf.parser.graph.IGraphParser;
import edu.cornell.cs.nlp.spf.test.Tester;
import edu.cornell.cs.nlp.spf.test.stats.ExactMatchTestingStatistics;
import edu.cornell.cs.nlp.utils.collections.SetUtils;
import edu.cornell.cs.nlp.utils.function.PredicateUtils;
import edu.cornell.cs.nlp.utils.log.ILogger;
import edu.cornell.cs.nlp.utils.log.Log;
import edu.cornell.cs.nlp.utils.log.LogLevel;
import edu.cornell.cs.nlp.utils.log.Logger;
import edu.cornell.cs.nlp.utils.log.LoggerFactory;


public class ExistingModel {
    private ExistingModel() {
        // Private ctor. Service class.
    }

    public static void main(String[] args) {


    }
}