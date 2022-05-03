<?php
  class Oggetto
  {
    private $nome;
    private $val;

    function __construct($nome,$val) {
      $this->nome = $nome;
      $this->val = $val;
    }

    function getNome(){return $this->nome;}
    function getVal() {return $this->val;}
    function sumVal($val){
      $this->val = $this->val + $val;
    }
  }

?>
