package com.loveandcomic.templatelistviewwithviewflipper;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;


/**
 * Viewフリッパーによる横スクロールアニメーションページ遷移のある
 * フラグメントのための共通抽象クラス
 *
 * @extends FragmentWithCommonNavi 共通ナビ部分を持つ抽象メソッド
 */
public abstract class AbsFragmentWithViewFlipper extends AbsFragmentWithCommonVariable{

	///////////////////////////////////////////////////////////
	//フィールド
	///////////////////////////////////////////////////////////

	//レイアウトインフレーター
	//→継承したクラスのonCreateView()で取得する
	protected LayoutInflater inflater;

	//枠になるビューフリッパーインスタンス
	//レイアウトXMLでのIDを「view_flipper」にすること
	protected ViewFlipper view_flipper;

	//アニメーション定義インスタンス
	protected Animation in_from_left;
	protected Animation in_from_right;
	protected Animation out_to_left;
	protected Animation out_to_right;

	//「戻る」ボタン
	protected Button return_button;

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
	 * @param レイアウトインフレーターオブジェクト
	 * @param ビューグループオブジェクト
	 * @param バンドルオブジェクト
	 */
	@Override
	public View onCreateView(
		LayoutInflater inflater,
		ViewGroup container,
		Bundle savedInstanceState
	){

		//レイアウトインフレーターオブジェクトに、用意したフラグメントのレイアウトXMLと、ビューグループインスタンスとを渡す。
		//レイアウトインフレーインスタンスのinflate()メソッドは、ビューのレイアウトXMLを読み込むための（インプットの）手続き。
		//リソース（XML）が第一引数、ビューグループが第二引数
		View rootView = inflater.inflate(
			R.layout.fragment_with_view_flipper, //レイアウトXMLファイル
			container,               //ビューグループインスタンス
			false
		);
		//リターンしているのでこれはブロックの最後に書く
		return rootView;

	}//function


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
	 * フラグメントでリストビューを制御する場合、
	 * onCreateViewではなく、onStartに記述する
	 */
	public void onStart(){
		super.onStart();

		//レイアウトインフレーターインスタンス
		this.inflater = this.my_activity.getLayoutInflater();

		//アニメーションのためにViewFlipperインスタンスを取得
		this.view_flipper = (ViewFlipper)this.my_activity.findViewById(R.id.view_flipper);

		//アニメーション定義インスタンス
		this.in_from_left  = AnimationUtils.loadAnimation(this.my_activity, R.anim.in_from_left);
		this.in_from_right = AnimationUtils.loadAnimation(this.my_activity, R.anim.in_from_right);
		this.out_to_left   = AnimationUtils.loadAnimation(this.my_activity, R.anim.out_to_left);
		this.out_to_right  = AnimationUtils.loadAnimation(this.my_activity, R.anim.out_to_right);

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
	 */

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
	 * 「戻る」ボタンのためのクリックリスナー
	 */
	public class ReturnButtonClickListener implements OnClickListener {
		@Override
		public void onClick(View view) {

			///////////////////////////////////////////
			//ページ遷移
			//◆インデックスページに戻る
			//◆現在表示中のページをビューフリッパーから削除してニュートラルな状態に戻す

			//右のページヘ移動するためのアニメーションを設定
			view_flipper.setInAnimation(in_from_left); //左からくる
			view_flipper.setOutAnimation(out_to_right);//右に行く

			//現在表示中のビューを取得する
			View current_view = view_flipper.getCurrentView();

			//前のページを表示
			view_flipper.showPrevious();

			//現在表示中のページをビューフリッパーから削除
			view_flipper.removeView(current_view);

		}//function


	}//class

}//class
