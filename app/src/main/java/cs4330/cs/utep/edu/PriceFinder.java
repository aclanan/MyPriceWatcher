package cs4330.cs.utep.edu;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DecimalFormat;

public class PriceFinder extends AsyncTask<Void,Void,Void> {
    protected Item item;

    public PriceFinder(Item i){
        this.item = item;
    }
    protected void getPrice(){
        new PriceFinder(this.item).execute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            Document itemDocument = Jsoup.connect(item.url).get();
            Elements priceDollars = itemDocument.select(".price__dollars");
            Elements priceCents = itemDocument.select(".price__cents");
            Log.d("Andrew",priceDollars.get(0).text());
//            for(int i = 0;i<priceDollars.size();i++){
//                Log.d("Andrew",priceDollars.get(i).text());
//            }



        }catch(IOException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
