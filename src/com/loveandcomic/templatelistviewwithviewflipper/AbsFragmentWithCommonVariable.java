package com.loveandcomic.templatelistviewwithviewflipper;

import java.util.logging.Logger;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

/**
 * インナークラスなどで使う共通の変数をあらかじめ作っておく抽象クラス
 * 各フラグメントクラスはこれ（あるいはこれを継承したクラス）を継承する
 */
public abstract class AbsFragmentWithCommonVariable extends Fragment {

	///////////////////////////////////////////////////////////
	//フィールド
	///////////////////////////////////////////////////////////
	//Androidはクリックリスナーなどインナークラスを持つことが多い
	//インナークラスでは、外側のクラスのフィールドにアクセスできる
	//インナークラス自体はアクティビティでもフラグメントでもないが、
	//それらを主語にしたいことが多い
	//なので、それら、共通で使いたいようなフィールドを
	//この抽象クラスで定義しておく
	//継承したクラスで使いたいので可視性はprotected

	//フィールドの変数の使い方
	//外側のクラス（持ち主としてthisを付ける）：this.変数名
	//インナークラス（持ち主を指定しない）：変数名

	//フラグメントの持ち主となるアクティビティ
	protected Activity my_activity;
	//フラグメント自身
	protected Fragment my_fragment;
	//持ち主のアクティビティのコンテキスト
	protected Context  my_context;

	protected Logger logger;


	///////////////////////////////////////////////////////////
	//メソッド ライフサイクル順
	///////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル01：onAttach()
	 * フラグメントがアクティビティから最初に取り付けられた時に
	 * 呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル02：onCreate()
	 * システムがフラグメントを作成した時に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル03：onCreateView()
	 * フラグメントが画面描画をはじめて行ったタイミングで
	 * 呼び出される。
	 *
	 * 【重要】
	 * フラグメントを使用する時、クラスに記述するべき
	 * 中心的メソッド。
	 *
	 * inflater.inflate()で取得するViewを戻す。
	 * そのとき、リソースのレイアウトXMLを指定する。
	 *
	 * ※継承先で実装
	 */


	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル04：onActivityCreated()
	 * 呼び出し元になるActivityのonCreateメソッドが完了したら
	 * 呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル05：onViewStateRestored()
	 * フラグメントのビュー階層の状態が復元されるときに
	 * 呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル06：onStart()
	 * フラグメントがユーザーに見えるように生成された
	 * タイミングで呼び出される。
	 *
	 * フィールドの作成
	 */
	@Override
	public void onStart(){
		super.onStart();

		this.my_activity = (Activity)this.getActivity();
		this.my_fragment = (Fragment)this;
		this.my_context  = (Context)this.my_activity.getApplicationContext();
		this.logger = Logger.getLogger("com.loveandcomic.templatemultifragment");
		this.logger.info("ロガー起動【 AbsFragmentWithCommonVariable - onStart() 】");

	}//function


	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル07：onResume()
	 * アクティビティがバックグラウンドからフォアグラウンドに
	 * 移るタイミングで呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル08：onPause()
	 * Activityがバックグラウンドに移ったか、もしくは
	 * アクティビティ内のフラグメントを変更する操作を行うことで
	 * ユーザーとの対話がされなくなった場合に呼び出される。
	 *
	 * フィールドの開放
	 */
	@Override
	public void onPause(){
		super.onPause();

		this.my_activity = null;
		this.my_fragment = null;
		this.my_context  = null;

	}//function


	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル09：onStop()
	 * アクティビティが停止したか、もしくはアクティビティ内の
	 * フラグメントを変更する操作を行うことでユーザーに表示され
	 * なくなった場合に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル10：onDestroyView()
	 * フラグメントのリソースをクリアする場合に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル11：onDestroy()
	 * フラグメントの状態が初期化される場合に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル12：onDetach()
	 * フラグメントがアクティビティから剥がされる直前に
	 * 呼び出される。
	 */


	///////////////////////////////////////////////////////////
	//メソッド 非ライフサイクル
	//抽象クラスの継承やインターフェイスの実装により
	//オーバーライドが義務化されるメソッドなど
	///////////////////////////////////////////////////////////
	/**
	 *
	 *
	 */

	///////////////////////////////////////////////////////////
	//クラス内クラス
	//タイマー処理などとの連携用
	///////////////////////////////////////////////////////////
	/**
	 *
	 *
	 */


}//class
