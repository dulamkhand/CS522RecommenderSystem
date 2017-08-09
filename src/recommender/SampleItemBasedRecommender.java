/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

/**
 *
 * @author 985892
 */
public class SampleItemBasedRecommender {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TasteException  {
        // TODO code application logic here
        DataModel model = new FileDataModel(new File("./dataset/dataset.csv"));
        
        ItemSimilarity similarity = new LogLikelihoodSimilarity(model);
        
        ItemBasedRecommender recommender = new GenericItemBasedRecommender(model, similarity);
        
        List recommendations = recommender.recommend(3, 4);
        for (Object recommendation : recommendations) {
            System.out.println((RecommendedItem) recommendation);
        }

    }
    
}
