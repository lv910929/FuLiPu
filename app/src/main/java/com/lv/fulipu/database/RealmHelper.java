package com.lv.fulipu.database;

import android.content.Context;

import com.lv.fulipu.model.MeiziRealmEntity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class RealmHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    public RealmHelper(Context mContext) {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder(mContext)
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    /**
     * 增加 收藏记录
     *
     * @param bean
     */
    public void insertLikeBean(MeiziRealmEntity bean) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(bean);
        mRealm.commitTransaction();
    }

    /**
     * 删除 收藏记录
     *
     * @param id
     */
    public void deleteLikeBean(String id) {
        MeiziRealmEntity data = mRealm.where(MeiziRealmEntity.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        data.deleteFromRealm();
        mRealm.commitTransaction();
    }

    /**
     * 查询 收藏记录
     *
     * @param id
     * @return
     */
    public boolean queryLikeId(String id) {
        RealmResults<MeiziRealmEntity> results = mRealm.where(MeiziRealmEntity.class).findAll();
        for (MeiziRealmEntity item : results) {
            if (item.get_id().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<MeiziRealmEntity> getLikeList() {
        //使用findAllSort ,先findAll再result.sort无效
        RealmResults<MeiziRealmEntity> results = mRealm.where(MeiziRealmEntity.class).findAllSorted("time");
        return mRealm.copyFromRealm(results);
    }

}
