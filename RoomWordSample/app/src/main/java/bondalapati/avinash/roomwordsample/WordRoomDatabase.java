package bondalapati.avinash.roomwordsample;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Word.class, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDao WordDao();

    private  static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class, "word_database")
                    //comment the following line of code to validate if it will cause any errors.
                    .fallbackToDestructiveMigration()
                    //adding a callback for the populating the db on open.
                    .addCallback(sRoomDatabaseCallback)
                    .build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new PopulateDBAsync(INSTANCE).execute();
        }

    };

    private static class PopulateDBAsync extends AsyncTask<Void,Void,Void>{
        private  final WordDao mDao;

        private PopulateDBAsync(WordRoomDatabase db) {
            mDao = db.WordDao();
        }


        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word("Avinash");
            mDao.insert(word);
            word = new Word("Avinash 1");
            mDao.insert(word);
            return null;
        }

    }
}
