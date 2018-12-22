import math
import re
from collections import Counter

docA = "the car is driven on the the road car"
docB = "the truck is driven on the highway"

corpus = []
corpus.append(docA)
corpus.append(docB)

##### HELPER FUNCTIONS BEGIN ######
def getNumOfOccurInDoc(word, docArray):
    cnt = 0
    for dc in docArray:
        if word == dc:
            cnt += 1
    return cnt

def getNumOfOccurInCorpus(word, doclist):
    cnt = 0
    contains = False
    for dc in doclist:
        dcArr = re.findall(r'\S+', dc) # split doc into words-array
        for d in dcArr:
            if word == d:
                contains = True
                break # if doc contains given word, break the loop and increment counter
        if contains:
            cnt += 1
            contains = False
    return cnt

def getParticularIDF(word, idfDict):
    for k, v in idfDict.iteritems():
        if k == word:
            return float(v)
    return float(0)
##### HELPER FUNCTIONS END ######

#####     TF,IDF,TFIDF FUNTIONS    ######
def getTfValues(doclist): # returns list of dictionary (dictionary per document)
    resultList = []
    for doc in doclist:
        docArr = re.findall(r'\S+', doc)
        sizeOfDocArr = len(docArr)
        docSet = set(docArr)
        docDic = {}
        for ds in docSet:
            docDic[ds] = getNumOfOccurInDoc(ds, docArr) / float(sizeOfDocArr) # divide total word count by total number of word in doc
        resultList.append(docDic)
    return resultList

def getIDFValues(doclist): # returns dictionary (dictionary of all corpus)
    corpus = ""
    for doc in doclist:
        corpus += (doc + ' ')
    corpusArr = re.findall(r'\S+', corpus)
    corpusSet = set(corpusArr) # remove duplicate items
    corpusDic = {}
    for ds in corpusSet:
       corpusDic[ds] =  math.log10(float(len(doclist)) / getNumOfOccurInCorpus(ds,doclist))
    return corpusDic

def getTfIDFValues(doclist): # return list of dictionary (dictionary per document)
    resultList = []
    tfValsDictList = getTfValues(doclist)
    idfValsDict = getIDFValues(doclist)
    for tfValsDict in tfValsDictList:
        docTfIDFDic = {}
        for tfWord, tfVal in tfValsDict.iteritems():
            docTfIDFDic[tfWord] =  tfVal * getParticularIDF(tfWord, idfValsDict) # tf * idf and save it to doc_cnt_dictionary(doc_1_dict)
        resultList.append(docTfIDFDic)
    return resultList

#### TEST BEGIN ####
print('\nTEST BEGIN\n')
print('TF VALUES:\n')
tfDictList = getTfValues(corpus)
cnt = 1
for tfDict in tfDictList:
    for word, tfVal in tfDict.iteritems():
        print('doc'+str(cnt)+' word: ' + word + ' tf: '+ str(tfVal))
    cnt += 1
    print('')

print('********************\n')

print('IDF VALUES:\n')
idfDict = getIDFValues(corpus)
for word, idfVal in idfDict.iteritems():
    print('word: ' + word + ' idf: ' + str(idfVal))

print('\n********************\n')
print('TFIDF VALUES:\n')
tfIdfDictList = getTfIDFValues(corpus)
cnt = 1
for tfIdfDict in tfIdfDictList:
    for word, tfidfVal in tfIdfDict.iteritems():
        print('doc'+str(cnt)+' word: ' + word + ' tfidf: '+ str(tfidfVal))
    cnt += 1
    print('')

print('\nTEST END\n')
#### TEST END ####
