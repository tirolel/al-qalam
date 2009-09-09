package com.uzislam.alqalam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class QuranActivity extends Activity {
	private ListView SurahList; 
		
	static String [] SURAHS = {"Fotiah", "Baqara"}; //getResources().getStringArray(R.string.SurahTitle);
	static int[] SURAHAYATS = new int[] {7,286,200,176,120,165,206,75,129,109,123,111,43,52,99,128,111,110,98,135,112,78,118,64,77,227,93,88,69,60,
    		34,30,73,54,45,83,182,88,75,85,54,53,89,59,37,35,38,29,18,45,60,49,62,55,78,96,29,22,24,13,14,11,11,18,12,12,30,52,52,44,28,
    		28,20,56,40,31,50,40,46,42,29,19,36,25,22,17,19,26,30,20,15,21,11,8,8,19,5,8,8,11,11,8,3,9,5,4,7,3,6,3,5,4,5,6};
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.quran);
        SurahList = (ListView)findViewById(R.id.SurahList);
        SurahList.setAdapter(new EfficientAdapter(this));
        SurahList.setDivider(null);
      
 	}
	
	private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private Bitmap mIconGet;
        private Bitmap mIconPlaying;
        private Bitmap mIconSound;

        public EfficientAdapter(Context context) {
            mInflater = LayoutInflater.from(context);

            // Icons bound to the rows.
            mIconGet = BitmapFactory.decodeResource(context.getResources(), R.drawable.index_sound_get);
            mIconSound = BitmapFactory.decodeResource(context.getResources(), R.drawable.index_sound);
            mIconPlaying = BitmapFactory.decodeResource(context.getResources(), R.drawable.index_sound_playing);
            
        }

        public int getCount() {
            return SURAHAYATS.length;
        }
       
        
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
                       
            if (convertView == null) {        
                convertView = mInflater.inflate(R.layout.surahrow, null);

                holder = new ViewHolder();
                holder.SurahTitle = (TextView) convertView.findViewById(R.id.srTitle);
                holder.SurahOrder = (TextView) convertView.findViewById(R.id.srOrder);
                holder.SurahAyats = (TextView) convertView.findViewById(R.id.srAyats);
                holder.SurahDwnState = (ImageView) convertView.findViewById(R.id.srDown);
                holder.SurahPlace = (ImageView) convertView.findViewById(R.id.srPlace);
                
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.SurahTitle.setText(""); //SURAHS[position]);
            holder.SurahOrder.setText(position+1);
            holder.SurahAyats.setText(SURAHAYATS[position]);
            holder.SurahDwnState.setImageBitmap(mIconGet);
            
            
            return convertView;
        }
        
        static class ViewHolder {
            TextView 	SurahTitle;
            TextView 	SurahOrder;
            TextView 	SurahAyats;
            ImageView 	SurahDwnState;
            ImageView 	SurahPlace;
        }
    }
}