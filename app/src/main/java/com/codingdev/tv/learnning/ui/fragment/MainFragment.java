package com.codingdev.tv.learnning.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.PresenterSelector;

import com.codingdev.tv.learnning.R;
import com.codingdev.tv.learnning.model.Card;
import com.codingdev.tv.learnning.model.CardRow;
import com.codingdev.tv.learnning.selector.CardPresenterSelector;
import com.codingdev.tv.learnning.utils.Utils;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MainFragment extends BrowseSupportFragment {

    private ArrayObjectAdapter mRowsAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUIElements();
        setupRowAdapter();
    }

    /**
     * set ui elements.
     */
    private void setUIElements() {
        setTitle(getString(R.string.browse_title));// set title.
        setBadgeDrawable(getResources().getDrawable(R.drawable.title_android_tv));//设置徽章图片
        setHeadersState(HEADERS_DISABLED);// 隐藏头布局，其实是左侧的侧边栏。
        setHeadersTransitionOnBackEnabled(false);
    }

    private void setupRowAdapter() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());//创建ArrayObjectAdapter,代表的是纵向列表的adapter.
        createRows();//获取数据并且添加到mRowsAdapter中
        setAdapter(mRowsAdapter);//设置mRowsAdapter到fragment. 其实底层也用的是RecyclerView,只不过针对Tv做了一些改进。
    }

    private void createRows() {
        String json = Utils.inputStreamToString(getResources().
                openRawResource(R.raw.launcher_cards)); //从raw中加载json数据
        CardRow[] cardRows = new Gson().fromJson(json, CardRow[].class);//每一个CardRow，代表一行横排数据，CardRow[]代表了几行横排数据。
        for (CardRow row : cardRows){
            mRowsAdapter.add(createCardRow(row));//将每一行横排数据添加到mRowsAdapter中。
        }
    }

    private ListRow createCardRow(CardRow cardRow) {
        PresenterSelector presenterSelector = new CardPresenterSelector(getActivity());//CardPresenterSelector中包含了每一衡行中没一个item展示的样式。
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(presenterSelector);//这个ArrayObjectAdapter代表的是横向列表中的adapter.
        for (Card card : cardRow.getCards()) {
            listRowAdapter.add(card);
        }
        return new ListRow(listRowAdapter);
    }

}