学習中に作った何かに使えそうだけど、使わないよなという感じのものを集めています。

1．easyAnnotation<br>
   クラス、メソッド、フィールドにアノテーションを付けることで定数を入力することができる。<br>

   new した部分のものを拾うような形で、インスタンス作成時にクラス、メソッドの定数は<br>
   GetStringArray内のclassAnnotationString,methodAnnotationStringに格納されます。<br>
   フィールドについてはインスタンス作成後createFieldAnnotationStringメソッドにて各フィールドへ格納します。<br>
   staticか否かでメソッド名が変わるのでご注意。<br>
   現在はString[]のみの対応になっているが、いずれ主要なクラスについて対応する予定<br>

