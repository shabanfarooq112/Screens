package com.example.screens.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.screens.R;
import com.example.screens.adapters.GroupNewsFeedAdapter;
import com.example.screens.adapters.MemberRecyclerViewAdapter;
import com.example.screens.adapters.ParentAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupsFragment extends Fragment {

    RecyclerView recyclerView , memberRecyclerView;

    GroupNewsFeedAdapter groupNewsFeedAdapter;
    MemberRecyclerViewAdapter memberRecyclerViewAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GroupsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroupsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupsFragment newInstance(String param1, String param2) {
        GroupsFragment fragment = new GroupsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groups, container, false);

        initComponent(view);
        initListener(view);
        SetAdapter();
        SetMemberRecyclerViewAdapter();


        return view;
    }

    private void SetMemberRecyclerViewAdapter() {
        memberRecyclerViewAdapter = new MemberRecyclerViewAdapter(getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        memberRecyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        memberRecyclerView.setAdapter(memberRecyclerViewAdapter);
    }

    private void initComponent(View view) {
        recyclerView = view.findViewById(R.id.news_feed_recyclerview);
        memberRecyclerView = view.findViewById(R.id.member_recyclerview);
    }

    private void SetAdapter() {
        groupNewsFeedAdapter = new GroupNewsFeedAdapter(getActivity());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity() , LinearLayoutManager.HORIZONTAL , false);
        recyclerView.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(groupNewsFeedAdapter);
    }

    private void initListener(View view) {

    }
}