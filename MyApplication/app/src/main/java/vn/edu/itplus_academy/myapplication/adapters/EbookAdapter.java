package vn.edu.itplus_academy.myapplication.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;



import java.util.List;

import vn.edu.itplus_academy.myapplication.models.Ebook;

public class EbookAdapter extends BaseAdapter {

    private List<Ebook> ebookList;

    private Activity activity;

    public EbookAdapter(List<Ebook> ebookList, Activity activity) {
        this.ebookList = ebookList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return ebookList.size();
    }

    @Override
    public Object getItem(int i) {
        return ebookList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       return null;
    }
}
