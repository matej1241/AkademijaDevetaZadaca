package hr.ferit.brunozoric.taskie.di

import hr.ferit.brunozoric.taskie.persistence.addTask.AddTaskRepository
import hr.ferit.brunozoric.taskie.persistence.addTask.AddTaskRepositoryImpl
import hr.ferit.brunozoric.taskie.persistence.login.LoginRepository
import hr.ferit.brunozoric.taskie.persistence.login.LoginRepositoryImpl
import hr.ferit.brunozoric.taskie.persistence.register.RegisterRepository
import hr.ferit.brunozoric.taskie.persistence.register.RegisterRepositoryImpl
import hr.ferit.brunozoric.taskie.persistence.tasks.TasksRepository
import hr.ferit.brunozoric.taskie.persistence.tasks.TasksRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory<LoginRepository>{ LoginRepositoryImpl(get()) }
    factory<RegisterRepository>{ RegisterRepositoryImpl(get()) }
    factory <TasksRepository> { TasksRepositoryImpl(get()) }
    factory <AddTaskRepository>{ AddTaskRepositoryImpl(get()) }
}