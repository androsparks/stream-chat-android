package com.getstream.sdk.chat.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getstream.sdk.chat.R;
import com.getstream.sdk.chat.rest.response.ChannelState;
import com.getstream.sdk.chat.view.MessageListViewStyle;

public class ThreadSeparatorViewHolder extends BaseMessageListItemViewHolder {

    private TextView tv_text;
    private MessageViewHolderFactory viewHolderFactory;
    public ThreadSeparatorViewHolder(int resId, ViewGroup viewGroup) {
        super(resId, viewGroup);
        tv_text = itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bind(Context context,
                     ChannelState channelState,
                     MessageListItem messageListItem,
                     int position) {
//        tv_text.setText();
    }

    @Override
    public void setViewHolderFactory(MessageViewHolderFactory factory) {
        this.viewHolderFactory = factory;
    }

}
