package com.getstream.sdk.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.getstream.sdk.chat.rest.response.ChannelState;
import com.getstream.sdk.chat.view.MessageListView;
import com.getstream.sdk.chat.view.MessageListViewStyle;

public abstract class BaseMessageListItemViewHolder extends RecyclerView.ViewHolder {

    protected MessageListView.BubbleHelper bubbleHelper;
    protected MessageListViewStyle style;

    public BaseMessageListItemViewHolder(int resId, ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
    }

    public abstract void bind(Context context,
                              ChannelState channelState,
                              @NonNull MessageListItem messageListItem,
                              int position);

    public abstract void setViewHolderFactory(MessageViewHolderFactory factory);

    public void setStyle(MessageListViewStyle style){
        this.style = style;
    }

    public void setBubbleHelper(MessageListView.BubbleHelper bubbleHelper) {
        this.bubbleHelper = bubbleHelper;
    }
}
