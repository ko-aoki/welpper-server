package jp.co.ysk.pepper.repository;

import jp.co.ysk.pepper.entity.TrnNumbering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// JpaRepository ジェネリクスの第一引数にエンティティクラス、第二引数に主キーのフィールド型
public interface TrnNumberingRepository extends JpaRepository<TrnNumbering, Integer>, JpaSpecificationExecutor<TrnNumbering> {

}