package com.getstream.sdk.chat.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.getstream.sdk.chat.adapter.AttachmentListItemAdapter;
import com.getstream.sdk.chat.adapter.Entity;
import com.getstream.sdk.chat.adapter.MessageViewHolderFactory;
import com.getstream.sdk.chat.model.Attachment;
import com.getstream.sdk.chat.model.Channel;
import com.getstream.sdk.chat.rest.Message;


public class AttachmentListView extends RecyclerView {
    final String TAG = AttachmentListView.class.getSimpleName();
    private MessageViewHolderFactory viewHolderFactory;

    private MessageListViewStyle style;
    private Message message;
    private Context context;
    private MessageListView.BubbleHelper bubbleHelper;
    private AttachmentListItemAdapter adapter;

    private MessageListView.AttachmentClickListener attachmentClickListener;

    public void setStyle(MessageListViewStyle style) {
        this.style = style;
    }

    public void setViewHolderFactory(MessageViewHolderFactory viewHolderFactory) {
        this.viewHolderFactory = viewHolderFactory;
    }

    public AttachmentListView(Context context) {
        super(context);
        this.context = context;
    }

    public AttachmentListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public AttachmentListView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setLayoutManager(new LinearLayoutManager(context));
        this.context = context;
    }

    public void setEntity(Entity entity) {
        this.message = entity.getMessage();
        this.setLayoutManager(new LinearLayoutManager(context));
        this.adapter = new AttachmentListItemAdapter(context, entity, viewHolderFactory);
        this.adapter.setStyle(style);
        if (this.attachmentClickListener != null) {
            this.adapter.setAttachmentClickListener(attachmentClickListener);
        }
        if (this.bubbleHelper != null) {
            this.adapter.setBubbleHelper(bubbleHelper);
        }
        this.setAdapter(adapter);
    }

    public void setAttachmentClickListener(MessageListView.AttachmentClickListener attachmentClickListener) {
        this.attachmentClickListener = attachmentClickListener;
        if (this.adapter != null) {
            this.adapter.setAttachmentClickListener(attachmentClickListener);
        }
    }

    public MessageListView.BubbleHelper getBubbleHelper() {
        return bubbleHelper;
    }

    public void setBubbleHelper(MessageListView.BubbleHelper bubbleHelper) {
        this.bubbleHelper = bubbleHelper;
        if (this.adapter != null) {
            this.adapter.setBubbleHelper(bubbleHelper);
        }
    }
}
