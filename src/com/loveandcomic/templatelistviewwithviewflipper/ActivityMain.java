package com.loveandcomic.templatelistviewwithviewflipper;
/**
 * リスト形式のビューを持ち、項目を選択すると
 * ビューフリッパーでフラグメント入れ替えを行う
 * サンプルプロジェクト
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * メインアクティビティ
 * フラグメントを動的に追加する
 * オプションメニューの設定
 */
public class ActivityMain extends Activity {

	///////////////////////////////////////////////////////////
	//フィールド
	///////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////
	//メソッド ライフサイクル順 アクティビティ用
	///////////////////////////////////////////////////////////

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル01：onCreate()
	 * 最初に呼び出される。初期化処理を行う
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState){
		//継承元クラスのメソッド実行
		super.onCreate(savedInstanceState);

		//レイアウトXMLファイルの指定 アクティビティ版
		setContentView(R.layout.activity_main);

		//現状ではアクティビティのレイアウトは空っぽなのでフラグメントを追加する
		//フラグメントがまだ空っぽであるなら
		if (savedInstanceState == null) {
			//ディフォルトでは以下の一行になっている
			//getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
			//これは4つのことを一行で同時に行っており、とてもわかりにくい。
			//なので、以下のように分割する。

			//フラグメントマネジャーインスタンスの取得
			FragmentManager fragment_manager = this.getFragmentManager();

			//フラグメントトランザクションインスタンス（フラグメントの追加や入れ替えを行う）の取得
			//Transactionは「処理、執行、取り扱い」という意味
			FragmentTransaction fragment_transaction = fragment_manager.beginTransaction();

			//フラグメントトランザクションインスタンスを使い、アクティビティのレイアウトXMLに置いてある
			//枠組みである「container」というIDのフレームレイアウトビューに、
			//フラグメントを扱うクラスである「PlaceholderFragment」（このクラスのインナークラスっだったものを
			//独立したファイルにしたもの）クラスのインスタンスを追加する。
			fragment_transaction.add(R.id.container, new FragmentMain());

			//追加されたフラグメントを描画する
			fragment_transaction.commit();
		}
	}//function

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル02：onRestart()
	 * Activityの停止後、再開する直前に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル03：onStart()
	 * 画面が表示される直前に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル04：onResume()
	 * ユーザーからの入力が可能となる直前に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル05：onPause()
	 * Activityから抜けようとした時に呼び出される。
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル06：onStop()
	 * Activityが非表示になった時に呼び出される
	 */

	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル07：onDestroy()
	 * Activityが破棄される時に呼び出される
	 */


	///////////////////////////////////////////////////////////
	//メソッド 非ライフサイクル
	//抽象クラスの継承やインターフェイスの実装により
	//オーバーライドが義務化されるメソッドなど
	///////////////////////////////////////////////////////////
	/**
	 * オプションメニューのためのクラス
	 * オプションメニュー作成
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		//res\menu内のXMLファイルの指定
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}//function

	/**
	 * オプションメニューのためのクラス
	 *
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//引数で渡されてくる「item」によって、どのオプションメニュー項目が
		//クリックされたのかが判別できる

		int id = item.getItemId();

		//res\menu内のXMLファイルに配置されたitem要素に割り当てているIDで判別する
		if(id == R.id.action_settings){
			//「action_settings」というIDのオプションメニュー項目がクリックされた時の処理
			return true;
		}
		return super.onOptionsItemSelected(item);
	}//function


	///////////////////////////////////////////////////////////
	//クラス内クラス
	//タイマー処理やフラグメントなどとの連携用
	///////////////////////////////////////////////////////////
	/**
	 *
	 *
	 */

}//class
