package bondalapati.avinash.roomdb;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Task.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract TaskDao TaskDao();
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE  = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"taskDB").addCallback(callback).build();
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback(){
      public void onOpen(@NonNull SupportSQLiteDatabase db){
          super.onOpen(db);
          new PopulateDBAsync(INSTANCE).execute();
      }
    };

    private static class PopulateDBAsync extends AsyncTask<Task,Void,Void>{

        private TaskDao taskDao;

        PopulateDBAsync(AppDatabase db){
            this.taskDao = db.TaskDao();
        }

        @Override
        protected Void doInBackground(Task... tasks) {
            taskDao.deleteAllTasks();
            taskDao.insertTask(new Task("taskOne","taskDesc1"));
            taskDao.insertTask(new Task("taskTwo","taskDesc2"));
            return null;
        }
    }
}
