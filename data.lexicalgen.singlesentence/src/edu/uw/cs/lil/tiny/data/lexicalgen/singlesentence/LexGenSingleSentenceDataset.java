/*******************************************************************************
 * UW SPF - The University of Washington Semantic Parsing Framework
 * <p>
 * Copyright (C) 2013 Yoav Artzi
 * <p>
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or any later version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 ******************************************************************************/
package edu.uw.cs.lil.tiny.data.lexicalgen.singlesentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import edu.uw.cs.lil.tiny.data.DatasetException;
import edu.uw.cs.lil.tiny.data.collection.IDataCollection;
import edu.uw.cs.lil.tiny.data.sentence.Sentence;
import edu.uw.cs.lil.tiny.data.singlesentence.SingleSentence;
import edu.uw.cs.lil.tiny.genlex.ccg.ILexiconGenerator;
import edu.uw.cs.lil.tiny.mr.lambda.LogicLanguageServices;
import edu.uw.cs.lil.tiny.mr.lambda.LogicalExpression;
import edu.uw.cs.lil.tiny.mr.lambda.LogicalExpressionRuntimeException;
import edu.uw.cs.lil.tiny.mr.lambda.visitor.IsWellTyped;
import edu.uw.cs.lil.tiny.mr.lambda.visitor.Simplify;
import edu.uw.cs.lil.tiny.utils.string.IStringFilter;

/**
 * Dataset of single sentences labeled with logical forms that can generate
 * lexical entries.
 * 
 * @author Yoav Artzi
 */
public class LexGenSingleSentenceDataset implements
		IDataCollection<LexGenSingleSentence> {
	private final List<LexGenSingleSentence>	data;
	
	public LexGenSingleSentenceDataset(List<LexGenSingleSentence> data) {
		this.data = Collections.unmodifiableList(data);
	}
	
	public static LexGenSingleSentenceDataset read(File f,
			IStringFilter textFilter,
			ILexiconGenerator<SingleSentence, LogicalExpression> genlex,
			boolean lockConstants) {
		try {
			// Open the file
			final BufferedReader in = new BufferedReader(new FileReader(f));
			final List<LexGenSingleSentence> data = new LinkedList<LexGenSingleSentence>();
			
			String line;
			String currentSentence = null;
			int readLineCounter = 0;
			while ((line = in.readLine()) != null) {
				++readLineCounter;
				if (line.startsWith("//") || line.equals("")) {
					// Case comment or empty line, skip
					continue;
				}
				line = line.trim();
				if (currentSentence == null) {
					// Case we don't have a sentence, so we are supposed to get
					// a sentence
					currentSentence = textFilter.filter(line);
				} else {
					// Case we don't have a logical expression, so we are
					// supposed to get it and create the data item
					final LogicalExpression exp;
					try {
						exp = Simplify.of(LogicalExpression.parse(line,
								LogicLanguageServices.getTypeRepository(),
								LogicLanguageServices.getTypeComparator(),
								lockConstants));
					} catch (final LogicalExpressionRuntimeException e) {
						// wrap with a dataset exception and throw
						in.close();
						throw new DatasetException(e, readLineCounter,
								f.getName());
					}
					if (!IsWellTyped.of(exp)) {
						// Throw exception
						in.close();
						throw new DatasetException(
								"Expression not well-typed: " + exp,
								readLineCounter, f.getName());
					}
					data.add(new LexGenSingleSentence(new Sentence(
							currentSentence), exp, genlex));
					currentSentence = null;
				}
			}
			in.close();
			return new LexGenSingleSentenceDataset(data);
		} catch (final IOException e) {
			// Wrap with dataset exception and throw
			throw new DatasetException(e);
		}
	}
	
	@Override
	public Iterator<LexGenSingleSentence> iterator() {
		return data.iterator();
	}
	
	@Override
	public int size() {
		return data.size();
	}
}
