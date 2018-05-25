# -*- coding: utf-8 -*-

import numpy
import argparse
from textProcessor import textProcessor
from Stemmer import Stemmer
import random
# from FileCryptor import FileCryptor
# import matplotlib.pyplot as plt
# from mpl_toolkits.mplot3d import Axes3D
# from sklearn.decomposition import PCA

parser = argparse.ArgumentParser(description='File path parser')
parser.add_argument('--text', '-t', type=str, required=True, help='Текст, подлежащий классификации')
parser.add_argument('--freq', '-f', default=1, type=int, help='Если слово встречактся в документе больше раз, чем'
                                                              ' задано здесь, то оно подлежит удалению')

args = parser.parse_args()

words = []

text = args.text
freq = args.freq

words.append(text)
words.append("политика страна парламент партия президент Путин диалог встреча глава свобода демократия обязательства"
             " сотрудничество агрессор план правительство депутат территория санкции реформа администрация саммит")
words.append("экономика финансы бизнес прибыль капитал риск кризис нарушения сделка договор контракт инвестиции налог"
             " миллиардер цены нефть экспорт газопровод акционер лицензия банк купить продать производство предприятие"
             " ипотека завод рабочий зарплата труд забастовка")
# words.append("наука учённые инженер врач открытие исследование разработка создание грант установка")
words.append("спорт соревнования олимпиада спортсмен рекорд достижение медаль награждение футбол воллейбол плавание"
             " стадион бег баскетбол гонки прыжок падение тренер сезон турнир финал лига чемпион")

TP = textProcessor()
ST = Stemmer()

words = [w.lower() for w in words]      # Переводим все строки в нижний регистр
words = TP.remove_symbols(words)        # Удаляем стоп-символы
words = TP.remove_stopwords(words)      # Удаляем стоп-слова

stemmed = []
for sentence in words:
    s = [ST.stem(i) for i in sentence]                # Производится стемминг
    stemmed.append(s)

keys = TP.remove_unique(stemmed, freq)                # Удаление слов, встречающихся во всех документах более freq раз/
                                                      # По умолчанию частота freq=1 равна еденице
                                                      # Получаем массив ключевых слов - термов

table, disp_table = TP.table_generator(keys, stemmed)          # Формируем частотную матрицу - table
                                                               # И таблицу частоты  встречаемости - disp_table
LA = numpy.linalg
freqMatrix = numpy.array(table)
terms, s, docs = LA.svd(freqMatrix, full_matrices=False)
assert numpy.allclose(freqMatrix, numpy.dot(terms, numpy.dot(numpy.diag(s), docs)))
new_a = numpy.dot(terms, numpy.dot(numpy.diag(s), docs))

termCords = [line[:3] for line in terms]                # Для обычного разложения
docCords = [line[:3] for line in docs.transpose()]

classified_text = docCords[0]

categories = ["Politics", "Economics", "Sports"]
k = 0
distDictionary = {}
for doc in docCords[1:]:
    if len(doc) < 3:
        dist = numpy.sqrt(((float(classified_text[0]) - float(doc[0])) ** 2) + ((float(classified_text[1]) - float(doc[1])) ** 2))
    else:
        dist = numpy.sqrt(((float(classified_text[0])-float(doc[0]))**2)+((float(classified_text[1])-float(doc[1]))**2)+
                      ((float(classified_text[2])-float(doc[2]))**2))
    distDictionary[categories[k]] = dist
    k += 1
#print(distDictionary)

l = lambda x: -x[1]
end = sorted(distDictionary.items(), key=l, reverse=True)
# print(end)
print(end[1:][0][0])
#with open("category.txt", "w", encoding='utf-8') as file:
#    file.write(end[1:][0][0])
