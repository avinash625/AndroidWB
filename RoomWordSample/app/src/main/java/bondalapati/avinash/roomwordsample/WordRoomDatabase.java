package bondalapati.avinash.roomwordsample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Word.class, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao WordDao();

    private  static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class, "word_database")
                    //comment the following line of code to validate if it will cause any errors.
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
}
