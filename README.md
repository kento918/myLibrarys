学習中に作った何かに使えそうだけど、使わないよなという感じのものを集めています。

1．easyAnnotation
   クラス、メソッド、フィールドにアノテーションを付けることで定数を入力することができる。
   new した部分のものを拾うような形で、インスタンス作成時にクラス、メソッドの定数はGetStringArray内の
   classAnnotationString,methodAnnotationStringに格納されます。
   フィールドについてはインスタンス作成後createFieldAnnotationStringメソッドにて各フィールドへ格納します。
   staticか否かでメソッド名が変わるのでご注意。
   現在はString[]のみの対応になっているが、いずれ主要なクラスについて対応する予定