package com.sample.demo.magic8ball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ChenYiTai on 4/18/16.
 */
public class HistoryAdapter extends ArrayAdapter<QuestionResponseModel> {

    private ArrayList<QuestionResponseModel> qrs;
    private Context contxt;

    private static class ViewHolder {
        public final TextView questionView;
        public final TextView responseView;

        public ViewHolder(TextView questionView, TextView responseView){
            this.questionView = questionView;
            this.responseView = responseView;
        }
    }

    public HistoryAdapter(Context context,ArrayList<QuestionResponseModel> qrs) {
        //super(context,R.layout.listrow, qrs);
        //String stringUrl = urlText;
        super(context,R.layout.listrow, qrs);
        this.qrs = qrs;
        this.contxt = context;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        TextView questionView;
        TextView responseView;


        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listrow, parent, false);
            questionView = (TextView)convertView.findViewById(R.id.text1);
            responseView = (TextView)convertView.findViewById(R.id.text2);
            convertView.setTag(new ViewHolder(questionView, responseView));
        }else
        {
            ViewHolder viewHolder = (ViewHolder)convertView.getTag();
            questionView = viewHolder.questionView;
            responseView = viewHolder.responseView;
        }

        QuestionResponseModel qr = qrs.get(position);

        if(questionView!=null)
        {
            questionView.setText(qr.getQuestion());
        }

        if(responseView!=null) {
            responseView.setText(qr.getResponse());
        }

        return convertView;

    }


}
