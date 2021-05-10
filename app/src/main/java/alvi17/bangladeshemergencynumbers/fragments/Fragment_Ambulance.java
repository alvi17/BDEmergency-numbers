package alvi17.bangladeshemergencynumbers.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

import java.util.HashMap;

import alvi17.bangladeshemergencynumbers.R;
import alvi17.bangladeshemergencynumbers.adapters.ExpandaleListAdapter;

/**
 * Created by User on 9/2/2017.
 */

public class Fragment_Ambulance extends Fragment{

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    String[] listDataHeader;
    HashMap<String,String[]> listDataChild;
    TextView headerText;
    NativeExpressAdView native_adView;
    VideoController mVideoController;
    AdView adView;


    public Fragment_Ambulance(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_police,container,false);

        expListView = (ExpandableListView) rootView.findViewById(R.id.expandableListView);
        headerText=(TextView)rootView.findViewById(R.id.headertextView);
        headerText.setText("মেডিকেল সার্ভিস এর নাম্বার সমূহ");

        // preparing list data
        prepareListData();

        listAdapter = new ExpandaleListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        native_adView = (NativeExpressAdView)rootView.findViewById(R.id.native_adView);
        native_adView.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

        mVideoController = native_adView.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.e("QA", "Video playback is finished.");
                super.onVideoEnd();
            }
        });


        native_adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                native_adView.setVisibility(View.VISIBLE);
                if (mVideoController.hasVideoContent()) {
                    Log.e("QA", "Received an ad that contains a video asset.");
                } else {
                    Log.e("QA", "Received an ad that does not contain a video asset.");
                }
            }
        });

        AdRequest request = new AdRequest.Builder().addTestDevice("0754C239B1E2E19421FDE46BCEFB8855").build();
        native_adView.loadAd(request);

        adView = (AdView) rootView.findViewById(R.id.adView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        if(adView!=null) {
            adView.loadAd(adRequest);
        }
    }

    public void prepareListData()
    {
        listDataHeader=getResources().getStringArray(R.array.ambulance_header);

        listDataChild=new HashMap<>();
        listDataChild.put(listDataHeader[0],getResources().getStringArray(R.array.medical_college));
        listDataChild.put(listDataHeader[1],getResources().getStringArray(R.array.ambulance_services));

    }
}
