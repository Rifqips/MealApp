package id.rifqipadisiliwangi.themealidbapp.data.local.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BookmarkDao_Impl implements BookmarkDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookmarkDataItem> __insertionAdapterOfBookmarkDataItem;

  private final EntityDeletionOrUpdateAdapter<BookmarkDataItem> __deletionAdapterOfBookmarkDataItem;

  private final EntityDeletionOrUpdateAdapter<BookmarkDataItem> __updateAdapterOfBookmarkDataItem;

  public BookmarkDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookmarkDataItem = new EntityInsertionAdapter<BookmarkDataItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BookmarkDataItem` (`id`,`strMealThumb`,`strMeal`,`strArea`,`strInstructions`,`strYoutube`,`idMeal`,`strCategory`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookmarkDataItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getStrMealThumb() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStrMealThumb());
        }
        if (value.getStrMeal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStrMeal());
        }
        if (value.getStrArea() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStrArea());
        }
        if (value.getStrInstructions() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStrInstructions());
        }
        if (value.getStrYoutube() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStrYoutube());
        }
        if (value.getIdMeal() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIdMeal());
        }
        if (value.getStrCategory() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStrCategory());
        }
      }
    };
    this.__deletionAdapterOfBookmarkDataItem = new EntityDeletionOrUpdateAdapter<BookmarkDataItem>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `BookmarkDataItem` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookmarkDataItem value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfBookmarkDataItem = new EntityDeletionOrUpdateAdapter<BookmarkDataItem>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `BookmarkDataItem` SET `id` = ?,`strMealThumb` = ?,`strMeal` = ?,`strArea` = ?,`strInstructions` = ?,`strYoutube` = ?,`idMeal` = ?,`strCategory` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookmarkDataItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getStrMealThumb() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getStrMealThumb());
        }
        if (value.getStrMeal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStrMeal());
        }
        if (value.getStrArea() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStrArea());
        }
        if (value.getStrInstructions() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStrInstructions());
        }
        if (value.getStrYoutube() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStrYoutube());
        }
        if (value.getIdMeal() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIdMeal());
        }
        if (value.getStrCategory() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStrCategory());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public void insertBookmark(final BookmarkDataItem bookmark) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBookmarkDataItem.insert(bookmark);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int deleteBookmark(final BookmarkDataItem bookmark) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__deletionAdapterOfBookmarkDataItem.handle(bookmark);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateBookmark(final BookmarkDataItem bookmark) {
    __db.assertNotSuspendingTransaction();
    int _total = 0;
    __db.beginTransaction();
    try {
      _total +=__updateAdapterOfBookmarkDataItem.handle(bookmark);
      __db.setTransactionSuccessful();
      return _total;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<BookmarkDataItem> getDataBookmark() {
    final String _sql = "SELECT * FROM BookmarkDataItem ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
      final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
      final int _cursorIndexOfStrArea = CursorUtil.getColumnIndexOrThrow(_cursor, "strArea");
      final int _cursorIndexOfStrInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "strInstructions");
      final int _cursorIndexOfStrYoutube = CursorUtil.getColumnIndexOrThrow(_cursor, "strYoutube");
      final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
      final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
      final List<BookmarkDataItem> _result = new ArrayList<BookmarkDataItem>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final BookmarkDataItem _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpStrMealThumb;
        if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
          _tmpStrMealThumb = null;
        } else {
          _tmpStrMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
        }
        final String _tmpStrMeal;
        if (_cursor.isNull(_cursorIndexOfStrMeal)) {
          _tmpStrMeal = null;
        } else {
          _tmpStrMeal = _cursor.getString(_cursorIndexOfStrMeal);
        }
        final String _tmpStrArea;
        if (_cursor.isNull(_cursorIndexOfStrArea)) {
          _tmpStrArea = null;
        } else {
          _tmpStrArea = _cursor.getString(_cursorIndexOfStrArea);
        }
        final String _tmpStrInstructions;
        if (_cursor.isNull(_cursorIndexOfStrInstructions)) {
          _tmpStrInstructions = null;
        } else {
          _tmpStrInstructions = _cursor.getString(_cursorIndexOfStrInstructions);
        }
        final String _tmpStrYoutube;
        if (_cursor.isNull(_cursorIndexOfStrYoutube)) {
          _tmpStrYoutube = null;
        } else {
          _tmpStrYoutube = _cursor.getString(_cursorIndexOfStrYoutube);
        }
        final String _tmpIdMeal;
        if (_cursor.isNull(_cursorIndexOfIdMeal)) {
          _tmpIdMeal = null;
        } else {
          _tmpIdMeal = _cursor.getString(_cursorIndexOfIdMeal);
        }
        final String _tmpStrCategory;
        if (_cursor.isNull(_cursorIndexOfStrCategory)) {
          _tmpStrCategory = null;
        } else {
          _tmpStrCategory = _cursor.getString(_cursorIndexOfStrCategory);
        }
        _item = new BookmarkDataItem(_tmpId,_tmpStrMealThumb,_tmpStrMeal,_tmpStrArea,_tmpStrInstructions,_tmpStrYoutube,_tmpIdMeal,_tmpStrCategory);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getValidateBookmark(final String idMeal,
      final Continuation<? super List<BookmarkDataItem>> continuation) {
    final String _sql = "SELECT * FROM BookmarkDataItem WHERE idMeal = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (idMeal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, idMeal);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<BookmarkDataItem>>() {
      @Override
      public List<BookmarkDataItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
          final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
          final int _cursorIndexOfStrArea = CursorUtil.getColumnIndexOrThrow(_cursor, "strArea");
          final int _cursorIndexOfStrInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "strInstructions");
          final int _cursorIndexOfStrYoutube = CursorUtil.getColumnIndexOrThrow(_cursor, "strYoutube");
          final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
          final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
          final List<BookmarkDataItem> _result = new ArrayList<BookmarkDataItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BookmarkDataItem _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpStrMealThumb;
            if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
              _tmpStrMealThumb = null;
            } else {
              _tmpStrMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
            }
            final String _tmpStrMeal;
            if (_cursor.isNull(_cursorIndexOfStrMeal)) {
              _tmpStrMeal = null;
            } else {
              _tmpStrMeal = _cursor.getString(_cursorIndexOfStrMeal);
            }
            final String _tmpStrArea;
            if (_cursor.isNull(_cursorIndexOfStrArea)) {
              _tmpStrArea = null;
            } else {
              _tmpStrArea = _cursor.getString(_cursorIndexOfStrArea);
            }
            final String _tmpStrInstructions;
            if (_cursor.isNull(_cursorIndexOfStrInstructions)) {
              _tmpStrInstructions = null;
            } else {
              _tmpStrInstructions = _cursor.getString(_cursorIndexOfStrInstructions);
            }
            final String _tmpStrYoutube;
            if (_cursor.isNull(_cursorIndexOfStrYoutube)) {
              _tmpStrYoutube = null;
            } else {
              _tmpStrYoutube = _cursor.getString(_cursorIndexOfStrYoutube);
            }
            final String _tmpIdMeal;
            if (_cursor.isNull(_cursorIndexOfIdMeal)) {
              _tmpIdMeal = null;
            } else {
              _tmpIdMeal = _cursor.getString(_cursorIndexOfIdMeal);
            }
            final String _tmpStrCategory;
            if (_cursor.isNull(_cursorIndexOfStrCategory)) {
              _tmpStrCategory = null;
            } else {
              _tmpStrCategory = _cursor.getString(_cursorIndexOfStrCategory);
            }
            _item = new BookmarkDataItem(_tmpId,_tmpStrMealThumb,_tmpStrMeal,_tmpStrArea,_tmpStrInstructions,_tmpStrYoutube,_tmpIdMeal,_tmpStrCategory);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
