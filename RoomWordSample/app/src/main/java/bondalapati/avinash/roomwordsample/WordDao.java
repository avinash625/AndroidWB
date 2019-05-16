package bondalapati.avinash.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(Word word);

    @Delete
    void delete(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAllWords();
}
