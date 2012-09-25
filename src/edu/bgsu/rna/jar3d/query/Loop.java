package edu.bgsu.rna.jar3d.query;

import java.util.List;

public interface Loop extends Iterable<String> {

	public List<String> getSequences();
	public String getType();
}