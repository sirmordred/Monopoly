# README BEFORE RUN XXX (Read Requirements and Compatibility)

## Requirements and Compatibility
- This script is only compatible with PYTHON 2 so run it with 'python2 ArticleMiner.py'
- Recommended environment is 'Ubuntu Terminal', run it from there (Running this script via IDEs like pycharm or anaconda is not adviced since it may not work) (**Windows OS: Tested, works good**) (**MacOS: Not tested**)
- You need to have Chrome browser already installed onto your machine (selenium requirements)
- Selenium (pip install selenium)
- Pdfminer (pip install pdfminer)
- Wordcloud (pip install wordcloud)
- Mathplotlib (wordcloud dependency, pip install matplotlib)
- Wget (pip install wget)
- Lxml (pip install lxml)
- Additional(if you are on Ubuntu): sudo apt-get install python-tk (wordcloud dependency)

## Test Correctness of TF,IDF,TFIDF FUNCTİONS
- No need to install anything, just run 'TestTFIDF.py'

## Info
ArticleMiner is written in pure python and it is a second term project developed for CSE3063 Object Oriented Software Design Course(Fall 2018)

Script downloads publications of selected faculy member at our department as pdf/word/txt and then outputs following files:
- tf_list.csv: Most frequent 50 words in the input set of documents, sorted descending by their term frequency (tf) coupled with their tf values (comma seperated file, example: document;7)
- tf_wordCloud.pdf: Word cloud of the these words
- tfidf_list.csv: Most frequent 50 words in the input set of documents, sorted descending by their term frequency*inverse document frequency (tf-idf) coupled with their tf-idf values (comma seperated file, example: document;2.8)
- tfidf_wordCloud.pdf: Word cloud of the these words

Contributors to this project are listed below:
- Alperen Bayar
- Büşra Yağcı 
- Oğuzhan Yiğit

You can open the whole project via PyCharm (check out from version control -> git)
