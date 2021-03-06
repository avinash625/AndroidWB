package bondalapati.avinash.roomdb;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = Task.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public abstract TaskDAO TaskModel();

    public static AppDatabase getInMemoryDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


    public static void destroyInstance(){INSTANCE = null;}

}
