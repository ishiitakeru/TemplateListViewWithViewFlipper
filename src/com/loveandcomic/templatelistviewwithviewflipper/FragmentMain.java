package com.loveandcomic.templatelistviewwithviewflipper;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * リストビューとビューフリッパーとを組み合わせたページ
 *
 */
public class FragmentMain extends AbsFragmentWithViewFlipper{

	///////////////////////////////////////////////////////////
	//フィールド インナークラスでも使いたい変数はフィールドに
	///////////////////////////////////////////////////////////
	//継承されたフィールド（一例 詳しくは AbsFragmentWithCommonVariable 参照）
	//◆Activity my_activity //フラグメントの持ち主となるアクティビティ
	//◆Fragment my_fragment //フラグメント自身
	//◆Context  my_context  //持ち主のアクティビティのコンテキスト

	//◆LayoutInflater inflater  //レイアウトインフレーター
	//◆ViewFlipper view_flipper //枠になるビューフリッパーインスタンス
	//◆Animation in_from_left   //アニメーション定義インスタンス
	//◆Animation in_from_right  //アニメーション定義インスタンス
	//◆Animation out_to_left    //アニメーション定義インスタンス
	//◆Animation out_to_right   //アニメーション定義インスタンス
	//◆Button return_button  //「戻る」ボタン

	//リストビューインスタンス
	private ListView list_view;
	//各項目のタイトルのためのコレクション
	private ArrayList<String> list_contents_titles;
	//リストビューに表示文字列を紐付けるためのアダプター
	private ArrayAdapter<String> list_adapter;

	//ガイドの各コンテンツ（レイアウトXMLをインフレーターでView化したもの）を保持するハッシュマップ
	private HashMap<String, View> list_contents;

	//WebViewインスタンス
	private WebView web_view;

	///////////////////////////////////////////////////////////
	//メソッド コンストラクタ
	///////////////////////////////////////////////////////////

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
	 * 戻り値がViewになっている。ここで返されたViewが描画される。
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
			R.layout.fragment_with_view_flipper, //レイアウトXMLのファイル名
			container,              //ビューグループインスタンス
			false
		);
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
	 * アニメーションの開始など、表示に関わる初期化処理を行う。
	 */
	public void onStart(){
		super.onStart();

		////////////////////////////////////////////////
		//ガイドに表示する項目の設定
		//ハッシュマップ（連想配列のように使われる）
		this.list_contents = new HashMap<String, View>();

		//レイアウトXMLをビューインスタンスに変換
		//LayoutInflater.inflate(
		//	int リソース,
		//	ViewGroup ルートになるビューグループ
		//)
		//：指定したリソース内のViewを読み込む

		//HashMap「list_contents」に格納
		//フィールドのレイアウトインフレーターはonCreateViewで作成されている
		this.list_contents.put("list_index"     , (View)this.inflater.inflate(R.layout.list_index,     null));
		this.list_contents.put("list_content01" , (View)this.inflater.inflate(R.layout.list_content01, null));
		this.list_contents.put("list_content02" , (View)this.inflater.inflate(R.layout.list_content02, null));
		this.list_contents.put("list_webview"   , (View)this.inflater.inflate(R.layout.webview_with_back_button, null));

		//各内容のビューをフリッパー（アニメーション遷移での入れ替え領域）に動的に追加
		this.view_flipper.addView(this.list_contents.get("list_index"));

		////////////////////////////////////////////////
		//ガイドコーナーのインデックスのリストビューの設定
		//リストビュー用にタイトルの文字列のコレクションを作成
		this.list_contents_titles = new ArrayList<String>();
		this.list_contents_titles.add("テスト1");
		this.list_contents_titles.add("テスト2");
		this.list_contents_titles.add("テスト3 WebView");

		//リストビューインスタンスの取得
		this.list_view = (ListView) my_activity.findViewById(R.id.list_index_list_view);

		//リスト用のアダプタを設定
		this.list_adapter = new ArrayAdapter<String>(
			this.my_context,          //コンテクストインスタンス
			R.layout.listview_common, //リストビューの見た目を定義するためのレイアウトXMLファイル名
			R.id.list_text,           //上記XML内の、テキストを表示するビューのID
			this.list_contents_titles
		);

		//リストビューにアダプタをヒモ付け、表示文字を設定
		this.list_view.setAdapter(this.list_adapter);

		//リストビューにイベントリスナーを追加する
		this.list_view.setOnItemClickListener(new GuideListViewOnItemClickListener());

	}//function


	///////////////////////////////////////////////////////////
	/**
	 * ライフサイクル07：onResume()
	 * アクティビティがバックグラウンドからフォアグラウンドに
	 * 移るタイミングで呼び出される。
	 *
	 * イベントリスナーの登録、タイマーの開始やデータの読み込みを行う。
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
	 *
	 * メモリを食うインスタンスの開放など
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
	 * リストビューがクリックされたら呼び出されるリスナー
	 */
	public class GuideListViewOnItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(
			AdapterView<?> parent, //呼び出されたリストビューインスタンス
			View view,             //クリックされたAdapterViewインスタンス
			int position,          //アダプタ内でのクリックされた位置
			long id                //選択されたアイテムのID
		){
			///////////////////////////////////////////
			//遷移してからじゃないと表示されないページのレイアウトXML
			//に配置されているView要素は、そのページのレイアウトXMLが
			//ビューフリッパーに追加された状態で
			//インスタンス化しないとエラーになる。

			///////////////////////////////////////////
			//ページ遷移
			//右のページヘ移動するためのアニメーションを設定
			view_flipper.setInAnimation(in_from_right); //右からくる
			view_flipper.setOutAnimation(out_to_left);  //左に行く

			//どの項目がクリックされたのかはpositionの数字でわかる
			//上から順番に0、1、2…
			if(position == 0){
				//ビューを動的に追加
				view_flipper.addView(list_contents.get("list_content01"));
			}//if

			if(position == 1){
				view_flipper.addView(list_contents.get("list_content02"));
			}//if

			//コンテンツをWebViewにする場合
			if(position == 2){
				view_flipper.addView(list_contents.get("list_webview"));

				//WebViewの設定
				web_view = (WebView) my_activity.findViewById(R.id.web_view_in_only);
				WebSettings web_seting = web_view.getSettings();
				web_seting.setJavaScriptEnabled(true);

				//WebViewにHTMLを関連付ける
				web_view.loadUrl("file:///android_asset/webview/index.html");
			}//if

			////////////////////////////////////////////////
			//「戻る」ボタンにイベントリスナーを設定
			//ボタンは、それが配置されているレイアウトXMLがビューフリッパーに
			//追加された状態でインスタンス化しないとエラーになる。
			return_button = (Button)my_activity.findViewById(R.id.return_button);
			return_button.setOnClickListener(new ReturnButtonClickListener());

			view_flipper.showNext();

		}//function

	}//class
	///////////////////////////////////////////////////////////


}//class
