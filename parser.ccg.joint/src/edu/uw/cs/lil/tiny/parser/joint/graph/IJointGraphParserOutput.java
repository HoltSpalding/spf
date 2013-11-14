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
package edu.uw.cs.lil.tiny.parser.joint.graph;

import java.util.List;

import edu.uw.cs.lil.tiny.parser.graph.IGraphParser;
import edu.uw.cs.lil.tiny.parser.joint.IJointOutput;
import edu.uw.cs.lil.tiny.utils.hashvector.IHashVector;
import edu.uw.cs.utils.composites.Pair;
import edu.uw.cs.utils.filter.IFilter;

/**
 * Output of joint inference with a graph-based parser ({@link IGraphParser}).
 * 
 * @author Yoav Artzi
 * @param <MR>
 * @param <ERESULT>
 */
public interface IJointGraphParserOutput<MR, ERESULT> extends
		IJointOutput<MR, ERESULT> {
	
	IHashVector expectedFeatures();
	
	/**
	 * Expected features using a joint filter.
	 * 
	 * @param filter
	 * @param maxOnly
	 *            Only consider parses that pass the filter and have maximal
	 *            score.
	 * @return
	 */
	IHashVector expectedFeatures(IFilter<ERESULT> filter, boolean maxOnly);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getAllParses();
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getAllParses(
			boolean includeFails);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getBestParses();
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getBestParses(
			boolean includeFails);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getBestParsesFor(
			Pair<MR, ERESULT> label);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getBestParsesForY(
			MR partialLabel);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getBestParsesForZ(
			ERESULT partialLabel);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getMaxParses(
			IFilter<Pair<MR, ERESULT>> filter);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getParses(
			IFilter<Pair<MR, ERESULT>> filter);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getParsesFor(
			Pair<MR, ERESULT> label);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getParsesForY(MR partialLabel);
	
	@Override
	List<? extends IJointGraphParse<MR, ERESULT>> getParsesForZ(
			ERESULT partialLabel);
	
	double norm();
	
	/**
	 * Normalization constant using a filter.
	 * 
	 * @param filter
	 * @param maxOnly
	 *            Only include max-scoring parses that pass the provided filter.
	 * @return
	 */
	double norm(IFilter<ERESULT> filter, boolean maxOnly);
}
