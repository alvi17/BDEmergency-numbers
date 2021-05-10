package alvi17.bangladeshemergencynumbers.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

import alvi17.bangladeshemergencynumbers.R;
import alvi17.bangladeshemergencynumbers.Util;

/**
 * Created by User on 8/30/2017.
 */

public class NationalHelpDeskFragment extends Fragment implements View.OnClickListener{

    public NationalHelpDeskFragment()
    {

    }

    Button national_help,police_help,rab_help,fire_service_help,a2i_help,ambulance_service_help;
    NativeExpressAdView native_adView;
    VideoController mVideoController;
    AdView adView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_help_desk,container,false);

        national_help=(Button)rootView.findViewById(R.id.national_helpdesk);
        national_help.setOnClickListener(this);

        police_help=(Button)rootView.findViewById(R.id.police_helpdesk);
        police_help.setOnClickListener(this);

        rab_help=(Button)rootView.findViewById(R.id.rab_helpdesk);
        rab_help.setOnClickListener(this);

        fire_service_help=(Button)rootView.findViewById(R.id.fire_service_helpdesk);
        fire_service_help.setOnClickListener(this);

        ambulance_service_help=(Button)rootView.findViewById(R.id.ambulance_helpdesk);
        ambulance_service_help.setOnClickListener(this);

        a2i_help=(Button)rootView.findViewById(R.id.a2i_helpdesk);
        a2i_help.setOnClickListener(this);


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

    @Override
    public void onClick(View view) {

        int id=view.getId();
        switch (id)
        {
            case R.id.national_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                Util.call(getActivity(),"999");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.police_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(getActivity(), "100");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.rab_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(getActivity(), "101");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.fire_service_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(getActivity(), "102");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.ambulance_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(getActivity(), "103");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.a2i_helpdesk:
                if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_SETTINGS) == PackageManager.PERMISSION_GRANTED) {
                    Util.call(getActivity(), "104");
                }
                else{
                    Toast.makeText(getActivity(),"আপনি কল পারমিশন অনুমোদন করেননি।",Toast.LENGTH_LONG).show();
                }
                break;

        }

    }
}
