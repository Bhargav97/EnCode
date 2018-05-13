package encoders.encode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView refCard, dsCard, algoCard, fbCard;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        refCard = (CardView) v.findViewById(R.id.refcardId);
        dsCard = (CardView) v.findViewById(R.id.dscardId);
        algoCard = (CardView) v.findViewById(R.id.algocardId);
        fbCard = (CardView) v.findViewById(R.id.fbcardId);
        refCard.setOnClickListener(this);
        dsCard.setOnClickListener(this);
        algoCard.setOnClickListener(this);
        fbCard.setOnClickListener(this);
        return v;
    }

    public void onClick(View v){
        Intent i;

        switch(v.getId()){
            case R.id.refcardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RefFragment()).commit();
                break;
            case R.id.dscardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new DSFragment()).commit();
                break;
            case R.id.algocardId:
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AlgoFragment()).commit();
                break;
            case R.id.fbcardId:
                Toast.makeText(getActivity(), "What's the hurry dude!!",
                        Toast.LENGTH_LONG).show();
                break;
        }

    }
}
