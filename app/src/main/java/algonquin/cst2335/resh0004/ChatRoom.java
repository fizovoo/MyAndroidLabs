package algonquin.cst2335.resh0004;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import algonquin.cst2335.resh0004.data.ChatRoomViewModel;
import algonquin.cst2335.resh0004.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.resh0004.databinding.ReceiveMessageBinding;
import algonquin.cst2335.resh0004.databinding.SentMessageBinding;

public class ChatRoom extends AppCompatActivity {

private ActivityChatRoomBinding binding;
    private RecyclerView.Adapter myAdapter;
    ChatRoomViewModel chatModel ;
    ArrayList<ChatMessage> messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatModel = new ViewModelProvider(this).get(ChatRoomViewModel.class);
        messages = chatModel.messages;
        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.sendButton.setOnClickListener(click -> {
            String typed = binding.editText.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
            String currentDateAndTime = sdf.format(new Date());
            ChatMessage typedMessage = new ChatMessage(typed, currentDateAndTime, true);
            messages.add(typedMessage);
            myAdapter.notifyItemInserted(messages.size()-1);
            binding.editText.setText("");
        });

        binding.receiveButton.setOnClickListener(click -> {
            String typed = binding.editText.getText().toString();
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MMM-yyyy hh-mm-ss a");
            String currentDateAndTime = sdf.format(new Date());
            ChatMessage typedMessage = new ChatMessage(typed, currentDateAndTime, false);
            messages.add(typedMessage);
            //Notify the adapter
            myAdapter.notifyItemInserted(messages.size()-1); //redraw missing row
            binding.editText.setText(""); //removed what was typed
        });


        binding.recycleView.setAdapter(myAdapter= new RecyclerView.Adapter<MyRowHolder>() {

                @NonNull
                @Override
                public MyRowHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType) {
                    if (viewType == 0) {
                        SentMessageBinding binding = SentMessageBinding.inflate(getLayoutInflater(), parent, false);
                        return new MyRowHolder(binding.getRoot());
                    } else {
                        ReceiveMessageBinding binding = ReceiveMessageBinding.inflate(getLayoutInflater(), parent, false);
                        return new MyRowHolder(binding.getRoot());
                    }
                }

                @Override
                public void onBindViewHolder (@NonNull MyRowHolder holder,int position){
                    ChatMessage message = messages.get(position);
                holder.messageText.setText(message.getMessage());
                holder.timeText.setText(message.getTimeSent());

            }

                @Override
                public int getItemCount () {

                    return messages.size();
            }

            @Override
                public int getItemViewType ( int position) {

                    ChatMessage message = messages.get(position);
                    if (message.getIsSentButton()) {
                        return 0;
                    } else return 1;
                }

            });
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));

    }
}

    class MyRowHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView timeText;
        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.message);
            timeText = itemView.findViewById(R.id.time);
        }
    }
