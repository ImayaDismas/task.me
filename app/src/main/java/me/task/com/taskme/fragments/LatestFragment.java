package me.task.com.taskme.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.task.com.taskme.R;
import me.task.com.taskme.adapters.JobsRecyclerViewAdapter;
import me.task.com.taskme.api.APIService;
import me.task.com.taskme.api.APIUrl;
import me.task.com.taskme.helper.JobsResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LatestFragment extends Fragment {

//    declare variable to used
    private RecyclerView latest_list;
    private OnFragmentInteractionListener mListener;

    public LatestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View latest =  inflater.inflate(R.layout.fragment_latest, container, false);
//        initialze the listview
        latest_list = (RecyclerView) latest.findViewById(R.id.latest);
        latest_list.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
//        start the progress dialog
        progressDialog.setMessage("Fetching jobs...");
        progressDialog.show();

        //        initialze the retrofit builder

//        OkHttpClient httpClient = new OkHttpClient.Builder()
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public okhttp3.Response intercept(Chain chain) throws IOException {
//                        Request.Builder ongoing = chain.request().newBuilder();
//                        ongoing.addHeader("Accept", "application/json;versions=1");
//                        if (SharedPrefManager.getInstance(getActivity().getApplicationContext()).isLoggedIn()) {
//                            ongoing.addHeader("Authorization", "token " + SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserToken());
//                        }
//                        return chain.proceed(ongoing.build());
//                    }
//                })
//                .build();

//        .client(httpClient)

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        initialize the api servive created
        APIService service = retrofit.create(APIService.class);

//        initiate a call to the service using the service created
        Call<JobsResult> call = service.getJobPosts();

        call.enqueue(new Callback<JobsResult>() {
            @Override
            public void onResponse(Call<JobsResult> call, Response<JobsResult> response) {
                progressDialog.dismiss();
                Log.e("RESPONSE", String.valueOf(response.body()));
//                check if error is true or false
                if (!response.body().getError()) {
//                    display the message if the post is successful
                    Toast.makeText(getActivity(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();
                    // Create the adapter to convert the array to views
                    JobsRecyclerViewAdapter adapter = new JobsRecyclerViewAdapter(getActivity(), response.body().getJobPosts());

                    // Attach the adapter to a ListView
                    latest_list.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(getActivity(), String.valueOf(response.body().getMessage()), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<JobsResult> call, Throwable t) {
//                if server URL is unreacheable display the error message on the toast
                progressDialog.dismiss();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return latest;
    }

}
