package edu.bgsu.rna.jar3d;

import java.util.*;

/**
 * 
 * @author Craig Zirbel
 *
 */
public class TotalProbabilityTests {
	public static void main(String[] args) {

		int numSequences = 10;
		int DNA = 0;
		int range = 20;

		if (args.length>0)
		{
			System.setProperty("user.dir",args[0]);
			DNA = (int)(Double.parseDouble(args[4]));
			List<Sequence> sequenceData = Alignment.loadFastaColumnsDNA(args[1],0,0,DNA); 
			numSequences = (int)(Double.parseDouble(args[3]));
			range        = (int)(Double.parseDouble(args[5]));
			sequenceData = Alignment.doParse(sequenceData, args[2], range);
			sequenceData = sequenceData.subList(0, numSequences + 1);
			Alignment.displayAlignmentFASTA(sequenceData);
		}
		else
		{
			// choose sequence data and a model that goes with it
			// for index restrictions to work, the first sequence needs to be at least as long as
			// the sequence in the 3D structure from which the model was derived, and preferably
			// not much longer
			List<Sequence> sequenceData = Alignment.loadFasta("C:/Users/zirbel/Documents/GitHub/JAR3D/sequences/IL_018_13_cWW-tSH-tHH-cSH-tWH-tHS-cWW.fasta");
			numSequences = sequenceData.size()-1;
			sequenceData = Alignment.doParse(sequenceData, "C:/Users/zirbel/Documents/GitHub/JAR3D/models/IL_018_13_cWW-tSH-tHH-cSH-tWH-tHS-cWW.txt",15);
			sequenceData = sequenceData.subList(0, numSequences + 1);
//			Alignment.displayAlignmentFASTA(sequenceData);

			String modelName = "C:/Users/zirbel/Documents/GitHub/JAR3D/totalprobabilitytests/IL_87904.3_model.txt";
			String seqName = "C:/Users/zirbel/Documents/GitHub/JAR3D/totalprobabilitytests/IL_87904.3.fasta";
			sequenceData = Alignment.loadFasta(seqName);			
			sequenceData = Alignment.calculateTotalProbability(sequenceData, modelName, range, false);

			for (int i=0; i<sequenceData.size(); i++) {
				System.out.println(sequenceData.get(i).totalProbability);
			}
			
		}
	}
	
}
