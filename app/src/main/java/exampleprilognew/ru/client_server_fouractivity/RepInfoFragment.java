package exampleprilognew.ru.client_server_fouractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Максим on 14.05.2017.
 */

public class RepInfoFragment extends Fragment {


    private Button btnCommit;
    private Button btnContributors;
    private TextView tvRepo;
    private TextView tvDescription;
    private Repo obj;

    public static final String COMMIT  ="commit";
    public static final String CONTRIBUT  ="contributors";
    public static final String REPO  = "repo";

    public RepInfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view =
                inflater.inflate(R.layout.repfragment, container, false);

        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCommit=(Button)view.findViewById(R.id.commits);
        btnContributors=(Button)view.findViewById(R.id.contributors);

        btnCommit.setOnClickListener(commitListener);
        btnContributors.setOnClickListener(contributorsListener);

        tvRepo=(TextView)view.findViewById(R.id.tvRepo);
        tvDescription=(TextView)view.findViewById(R.id.tvDescription);

         Intent intentRepo=getActivity().getIntent();


        obj=(Repo) intentRepo.getSerializableExtra(REPO);


        tvRepo.setText(obj.getName());
        tvDescription.setText(obj.getDescription());

    }


    private View.OnClickListener commitListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentcommit = new Intent(getContext(),CommitsActivity.class);

            intentcommit.putExtra(COMMIT,obj.getName());

            startActivity(intentcommit);
        }
    } ;


    private View.OnClickListener contributorsListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intentcontributors = new Intent(getContext(),ContributorsActivity.class);

            intentcontributors.putExtra(CONTRIBUT,obj.getName());

            startActivity(intentcontributors);
        }
    } ;

}